package cn.wochu.wh.entity;

/**
 * project name：PrefixStorageProject
 * class describe：
 * create person：dayongxin
 * create time：16/6/12 下午3:41
 * alter person：dayongxin
 * alter time：16/6/12 下午3:41
 * alter remark：
 */
public class MainPageTitleEntity {
    public MainPageTitleEntity(String titleName) {
        this.titleName = titleName;
    }

    private String titleName;

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
}
