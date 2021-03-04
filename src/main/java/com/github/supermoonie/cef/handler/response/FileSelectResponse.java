package com.github.supermoonie.cef.handler.response;

/**
 * @author supermoonie
 * @since 2021/3/4
 */
public class FileSelectResponse {

    private String path;

    private Long size;

    private String modifyDate;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }
}
