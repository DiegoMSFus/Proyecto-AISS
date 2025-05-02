package ProyectoAiss.BitBucket.etl;

import ProyectoAiss.BitBucket.model.BitBucket.BComment;
import ProyectoAiss.BitBucket.model.BitBucket.BCommit;
import ProyectoAiss.BitBucket.model.BitBucket.BIssue;
import ProyectoAiss.BitBucket.model.BitBucket.CommitData.BCCommitData;
import ProyectoAiss.BitBucket.model.BitBucket.BUser;
import ProyectoAiss.BitBucket.model.BitBucket.IssueData.BIComments;
import ProyectoAiss.BitBucket.model.BitBucket.IssueData.BIssueData;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransformerBitBucket {
    public BCommit transformCommit(BCCommitData bitBucketCommit) {
        BCommit commit = new BCommit();

        commit.setId(bitBucketCommit.hash);
        commit.setTitle(bitBucketCommit.message.split("\n")[0]);
        commit.setMessage(bitBucketCommit.message);
        commit.setAuthoredDate(bitBucketCommit.date);
        commit.setAuthorName(bitBucketCommit.author.user.displayName);
        String raw = bitBucketCommit.author.raw;
        String email = raw != null && raw.contains("<") ? raw.substring(raw.indexOf("<") + 1, raw.indexOf(">")) : "";
        commit.setAuthorEmail(email);
        commit.setWebUrl(bitBucketCommit.links.BCHtml.href);
        if (bitBucketCommit.repository != null) {
            commit.setRepositoryId(bitBucketCommit.repository.uuid);
            commit.setRepositoryName(bitBucketCommit.repository.name);

            if (bitBucketCommit.repository.BCLinks != null &&
                    bitBucketCommit.repository.BCLinks.BCHtml != null) {
                commit.setRepositoryUrl(bitBucketCommit.repository.BCLinks.BCHtml.href);
            } else {
                commit.setRepositoryUrl(null);
            }
        }


        return commit;
    }

    public BComment transformComment(BIComments bitBucketIssueComment) {
        BUser user = null;

        if (bitBucketIssueComment.user != null) {
            user = new BUser();
            user.setId(bitBucketIssueComment.user.uuid);
            user.setUsername(bitBucketIssueComment.user.nickname);
            user.setName(bitBucketIssueComment.user.displayName);

            if (bitBucketIssueComment.user.BILinks != null) {
                if (bitBucketIssueComment.user.BILinks.comments != null) {
                    user.setAvatarUrl(bitBucketIssueComment.user.BILinks.avatar.href);
                }
                if (bitBucketIssueComment.user.BILinks.html != null) {
                    user.setWebUrl(bitBucketIssueComment.user.BILinks.html.href);
                }
            }
        }

        BComment comment = new BComment();
        comment.setId(bitBucketIssueComment.id.toString());
        comment.setAuthor(user);

        if (bitBucketIssueComment.BIContent != null && bitBucketIssueComment.BIContent.raw != null) {
            comment.setBody(bitBucketIssueComment.BIContent.raw);
        } else {
            comment.setBody("(no content)");
        }

        comment.setCreatedAt(bitBucketIssueComment.createdOn);

        if (bitBucketIssueComment.updatedOn != null) {
            comment.setUpdatedAt(bitBucketIssueComment.updatedOn.toString());
        }

        return comment;
    }


    public BIssue transformIssue(BIssueData issueData, List<BComment> comments) {
        BIssue issue = new BIssue();

        issue.setId(issueData.id != null ? issueData.id.toString() : null);

        if (issueData.content != null && issueData.content.raw != null) {
            String[] lines = issueData.content.raw.split("\n", 2);
            issue.setTitle(lines[0]);
            issue.setDescription(lines.length > 1 ? lines[1] : lines[0]);
        } else {
            issue.setTitle("(no content)");
            issue.setDescription("");
        }

        // Estado
        issue.setState(issueData.state);
        issue.setCreatedAt(issueData.createdOn);
        issue.setUpdatedAt(issueData.updatedOn);
        issue.setClosedAt("closed".equalsIgnoreCase(issueData.state) ? issueData.updatedOn : null);

        if (issueData.reporter != null) {
            BUser author = new BUser();
            author.setId(issueData.reporter.uuid);
            author.setUsername(issueData.reporter.nickname);
            author.setName(issueData.reporter.displayName);

            if (issueData.reporter.BILinks != null) {
                if (issueData.reporter.BILinks.avatar != null)
                    author.setAvatarUrl(issueData.reporter.BILinks.avatar.href);
                if (issueData.reporter.BILinks.html != null)
                    author.setWebUrl(issueData.reporter.BILinks.html.href);
            }

            issue.setAuthor(author);
        } else {
            issue.setAuthor(null);
        }

        issue.setAssignee(null);
        issue.setLabels(new ArrayList<>());
        issue.setComments(comments);

        return issue;
    }

}
