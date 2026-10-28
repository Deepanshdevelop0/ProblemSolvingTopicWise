package DesignPatterns.practice.Creational.Builder.objectBuilder;

import LeetCode.DP.Revision.Unique_Paths;

import java.util.List;

public class AzureVmDeploymentConfig {

    /* mandatory OS RAM size, but has dozens of optional configurations (GPU type, SSD storage, virtual network rules, tags).*/

    public enum Region {
        US, EU, SE, RU
    }
    public enum OS {
        WINDOWS, LINUX, UNIX, MACOS
    }
    private Integer ramSize;
    private OS operatingSystem;
    private String gpuType;
    private Integer ssdStorage;
    private List<String> vnRules;
    private List<String> tags;
    private Region region;

    private AzureVmDeploymentConfig(Builder builder) {
        this.ramSize = builder.ramSize;
        this.operatingSystem = builder.operatingSystem;
        this.gpuType = builder.gpuType;
        this.ssdStorage = builder.ssdStorage;
        this.vnRules = builder.vnRules;
        this.tags = builder.tags;
        this.region = builder.region;
    }

    public static class Builder {

        private Integer ramSize;
        private OS operatingSystem;
        private String gpuType;
        private Integer ssdStorage;
        private List<String> vnRules;
        private List<String> tags;
        private Region region;

        public Builder(Integer ramSize, OS operatingSystem) {
            this.ramSize = ramSize;
            this.operatingSystem = operatingSystem;
        }

        public Builder setGpuType(String gpuType) {
            this.gpuType = gpuType;
            return this;
        }

        public Builder setSsdStorage(Integer ssdStorage) {
            this.ssdStorage = ssdStorage;
            return this;
        }

        public Builder setVnRules(List<String> vnRules) {
            this.vnRules = vnRules;
            return this;
        }

        public Builder setTags(List<String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder setRegion(Region region) {
            this.region = region;
            return this;
        }

        public AzureVmDeploymentConfig build() {
            return new AzureVmDeploymentConfig(this);
        }

    }
}
