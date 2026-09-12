package builder;

import java.util.ArrayList;
import java.util.List;

public class SmmCampaign {
    private final String campaignName;
    private final String targetAudience;
    private final List<String> platforms;
    private final double budget;
    private final boolean includesVisualLayout;

    // Package-private constructor so only the Builder can instantiate it
    SmmCampaign(String campaignName, String targetAudience, List<String> platforms,
                double budget, boolean includesVisualLayout) {
        this.campaignName = campaignName;
        this.targetAudience = targetAudience;
        this.platforms = new ArrayList<>(platforms);
        this.budget = budget;
        this.includesVisualLayout = includesVisualLayout;
    }

    @Override
    public String toString() {
        return "SmmCampaign {" +
                "Name='" + campaignName + '\'' +
                ", Audience='" + targetAudience + '\'' +
                ", Platforms=" + platforms +
                ", Budget=$" + budget +
                ", Includes Visual Layout Planning=" + includesVisualLayout +
                '}';
    }
}