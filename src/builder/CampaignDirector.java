package builder;

public class CampaignDirector {

    public void constructInstagramVisualPromo(SmmCampaignBuilder builder) {
        builder.setCampaignName("Insta Aesthetic Promo")
                .setTargetAudience("Gen Z & Millennials")
                .addPlatform("Instagram")
                .setIncludesVisualLayout(true)
                .setBudget(300.0);
    }

    public void constructCrossPlatformBlast(SmmCampaignBuilder builder) {
        builder.setCampaignName("Mass Market Launch")
                .setTargetAudience("Broad Audience 18-45")
                .addPlatform("Instagram")
                .addPlatform("TikTok")
                .addPlatform("Facebook")
                .setIncludesVisualLayout(false)
                .setBudget(1500.0);
    }
}