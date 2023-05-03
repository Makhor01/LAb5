package collectionClases;

public enum OrganizationType {
    COMMERCIAL,
    GOVERNMENT,
    PRIVATE_LIMITED_COMPANY,
    OPEN_JOINT_STOCK_COMPANY;

    @Override
    public String toString() {
        return "OrganizationType:"+"\'"
                +"COMMERCIAL" +"\'"
                +"GOVERNMENT"+ "\'"
                +"PRIVATE_LIMITED_COMPANY" +'\''
                +"OPEN_JOINT_STOCK_COMPANY" +'\'';
    }
}

