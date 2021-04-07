/**
 * @author dsx
 */
public class AuthManager {
    private String unit;
    private Integer communityId;
    private String fkDrugInfoList;

    public AuthManager() {
    }

    public AuthManager(String unit, Integer communityId, String fkDrugInfoList) {
        this.unit = unit;
        this.communityId = communityId;
        this.fkDrugInfoList = fkDrugInfoList;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getCommunityId() {
        return communityId;
    }

    public void setCommunityId(Integer communityId) {
        this.communityId = communityId;
    }

    public String getFkDrugInfoList() {
        return fkDrugInfoList;
    }

    public void setFkDrugInfoList(String fkDrugInfoList) {
        this.fkDrugInfoList = fkDrugInfoList;
    }
}
