package com.paohaijiao.javelin.obj;

import java.util.List;

public class JsonBean {

    /**
     * name : 示例JSON
     * version : 1.0
     * description : 这是一个示例JSON文件，用于演示基本结构。
     * author : 你的名字
     * features : ["简单","易读","可扩展"]
     * metadata : {"created":"2023-10-01","modified":"2023-10-02"}
     * active : true
     * count : 42
     */

    private String name;
    private String version;
    private String description;
    private String author;
    private MetadataBean metadata;
    private boolean active;
    private int count;
    private List<String> features;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public MetadataBean getMetadata() {
        return metadata;
    }

    public void setMetadata(MetadataBean metadata) {
        this.metadata = metadata;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public static class MetadataBean {
        /**
         * created : 2023-10-01
         * modified : 2023-10-02
         */

        private String created;
        private String modified;

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getModified() {
            return modified;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }
    }
}
