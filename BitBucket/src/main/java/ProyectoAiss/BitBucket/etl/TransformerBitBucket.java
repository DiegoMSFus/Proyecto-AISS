package ProyectoAiss.BitBucket.etl;

import ProyectoAiss.BitBucket.model.BitBucket.BComment;
import ProyectoAiss.BitBucket.model.BitBucket.BCommit;
import ProyectoAiss.BitBucket.model.BitBucket.BIssue;
import ProyectoAiss.BitBucket.model.BitBucket.CommitData.BCCommitData;
import ProyectoAiss.BitBucket.model.BitBucket.BUser;
import ProyectoAiss.BitBucket.model.BitBucket.IssueData.BIComments;
import ProyectoAiss.BitBucket.model.BitBucket.IssueData.BIssueData;

import java.util.ArrayList;

public class TransformerBitBucket {
    public BCommit transformCommit(BCCommitData bitBucketCommit) {
        BCommit commit = new BCommit();

        commit.setId(bitBucketCommit.hash);
        commit.setTitle("");
        commit.setMessage(bitBucketCommit.message);
        commit.setAuthoredDate(bitBucketCommit.date);
        commit.setAuthorName(bitBucketCommit.author.user.displayName);
        commit.setAuthorEmail("");
        commit.setWebUrl(bitBucketCommit.links.BCHtml.href);

        return commit;
    }

    public BComment transformComment(BIComments bitBucketIssueComment) {
        BUser user = new BUser();
        user.setAvatarUrl(bitBucketIssueComment.user.avatar.href);
        user.setName(bitBucketIssueComment.user.displayName);
        user.setId(bitBucketIssueComment.user.uuid);
        user.setWebUrl(bitBucketIssueComment.user.BCLinks.BCHtml.href);
        user.setUsername(bitBucketIssueComment.user.nickname);
        BComment comment = new BComment();

        comment.setId(bitBucketIssueComment.id.toString());
        comment.setAuthor(user);
        comment.setBody(bitBucketIssueComment.BIContent.raw);
        comment.setCreatedAt(bitBucketIssueComment.createdOn);
        comment.setUpdatedAt(bitBucketIssueComment.updatedOn.toString());

        return comment;
    }

    public BIssue transformIssue(BIssueData bitBucketIssueData) {
        BIssue issue = new BIssue();
        BUser user = new BUser();
        BComment comments = transformComment(null);
        user.setAvatarUrl(bitBucketIssueData.reporter.avatar.href);
        user.setName(bitBucketIssueData.reporter.displayName);
        user.setId(bitBucketIssueData.reporter.uuid);
        user.setWebUrl(bitBucketIssueData.reporter.BCLinks.BCHtml.href);
        user.setUsername(bitBucketIssueData.reporter.nickname);

        issue.setId(bitBucketIssueData.reporter.uuid.toString());
        issue.setTitle(bitBucketIssueData.title);
        issue.setDescription(bitBucketIssueData.content.raw);
        issue.setState(bitBucketIssueData.state);
        issue.setCreatedAt(bitBucketIssueData.createdOn.toString());
        issue.setUpdatedAt(bitBucketIssueData.updatedOn.toString());
        issue.setLabels(new ArrayList<>());
        issue.setAuthor(user);
        issue.setAssignee(null);
        issue.setComments(comments);


        return issue;
    }
}
