package ProyectoAiss.BitBucket.etl;

import ProyectoAiss.BitBucket.model.BitBucket.Commit;
import ProyectoAiss.BitBucket.model.BitBucket.CommitData.CommitData;
import ProyectoAiss.BitBucket.model.BitBucket.CommitData.User;

public class TransformerBitBucket {
    public Commit transformCommit(CommitData bitBucketCommit) {
        Commit commit = new Commit();
        User author = new User();
        

        commit.setId(bitBucketCommit.hash);
        commit.setTitle("");
        commit.setMessage(bitBucketCommit.message);
        commit.setAuthoredDate(bitBucketCommit.date);



        return commit;
    }
}
