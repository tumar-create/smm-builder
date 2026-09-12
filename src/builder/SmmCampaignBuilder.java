package builder;

import java.util.ArrayList;
import java.util.List;

public class SmmCampaignBuilder {
    private String campaignName;
    private String targetAudience;
    private List<String> platforms = new ArrayList<>();
    private double budget;
    private boolean includesVisualLayout;

    private static final double MINIMUM_BUDGET = 50.0; // Clean Code: No magic numbers

    public SmmCampaignBuilder setCampaignName(String campaignName) {
        this.campaignName = campaignName;
        return this; // Fluent API
    }

    public SmmCampaignBuilder setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
        return this;
    }

    public SmmCampaignBuilder addPlatform(String platform) {
        this.platforms.add(platform);
        return this;
    }

    public SmmCampaignBuilder setBudget(double budget) {
        this.budget = budget;
        return this;
    }

    public SmmCampaignBuilder setIncludesVisualLayout(boolean includesVisualLayout) {
        this.includesVisualLayout = includesVisualLayout;
        return this;
    }

    public SmmCampaign build() {
        // Clean Code: Validated construction
        if (campaignName == null || campaignName.trim().isEmpty()) {
            throw new IllegalStateException("Campaign name must be specified.");
        }
        if (budget < MINIMUM_BUDGET) {
            throw new IllegalStateException("Budget must be at least $" + MINIMUM_BUDGET);
        }
        return new SmmCampaign(campaignName, targetAudience, platforms, budget, includesVisualLayout);
    }
}
