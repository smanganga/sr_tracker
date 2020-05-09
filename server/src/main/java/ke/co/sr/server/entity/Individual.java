package ke.co.sr.server.entity;

import javax.persistence.*;

@Entity
@Table(name = "individual")
public class Individual extends Actor{
    @ManyToOne
    @JoinColumn(name = "op_block_id")
    private Block operatingBlock;
    @ManyToOne
    @JoinColumn(name = "res_block_id")
    private Block residingBlock;

}
