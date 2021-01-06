package Model;

/**
 * 封装若干个广告
 */
public class AdvertisingBoard {
    private Advertisement [] advertisements=null;
    int index=-1;


    public void setAdvertisement(Advertisement[] advertisement) {
        this.advertisements = advertisement;
    }

    /**
     * 获取其中的一个广告
     * @param i 索引
     * @return
     */
    public Advertisement getadvertisement(int i){
        if(advertisements==null){
            return null;
        }
        if(advertisements.length==0){
            return null;
        }
        if(i>=advertisements.length||i<0){
            return null;
        }
        return advertisements[i];
    }
    //下一个广告
    public Advertisement nextAdvertisement(){
        index++;
        if (advertisements==null){
            return null;
        }
        if (advertisements.length==0){
            return null;
        }
        if (index==advertisements.length){
            index=0;
        }
        return advertisements[index];
    }
    //上一个广告
    public Advertisement previousAdvertisement(){
        index--;
        if (advertisements==null){
            return null;
        }
        if (advertisements.length==0){
            return null;
        }
        if (index<0){
            index=advertisements.length-1;
        }
        return advertisements[index];
    }
}


















