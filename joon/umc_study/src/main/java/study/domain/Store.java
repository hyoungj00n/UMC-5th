package study.domain;
import javax.persistence.*;
import lombok.*;
import study.domain.common.BaseEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 30)
    private String address;

    private Float score;

    @OneToMany(mappedBy = "store")
    private List<Mission> missionList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();


    public void setRegion(Region region){
        if (this.region != null){
            region.getStoreList().remove(this);
        }
        this.region = region;
        region.getStoreList().add(this);
    }



}
