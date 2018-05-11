package top.crazybanana.domain.common;

import java.util.List;

public class P<T> {
    private Integer pageIndex; //页码
    private Integer pageSize;  //页容量
    private Integer pageCount; //页数
    private List<T> data;

    public P(Integer index, Integer size, Integer count, List<T> data){
        this.pageIndex = index;
        this.pageSize = size;
        this.pageCount = count;
        this.data = data;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
