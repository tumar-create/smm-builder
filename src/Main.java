import builder.*;

public class Main {
    public static void main(String[] args) {
        CampaignDirector director = new CampaignDirector();

        // 1. Using Director for a preset campaign
        SmmCampaignBuilder instagramBuilder = new SmmCampaignBuilder();
        director.constructInstagramVisualPromo(instagramBuilder);
        SmmCampaign instaPromo = instagramBuilder.build();
        System.out.println("Director Build 1: " + instaPromo);

        SmmCampaignBuilder blastBuilder = new SmmCampaignBuilder();
        director.constructCrossPlatformBlast(blastBuilder);
        SmmCampaign crossPlatformPromo = blastBuilder.build();
        System.out.println("Director Build 2: " + crossPlatformPromo);

        // 2. Using Builder directly for a custom configuration
        SmmCampaign customCampaign = new SmmCampaignBuilder()
                .setCampaignName("Niche Twitter Thread")
                .setTargetAudience("Tech Enthusiasts")
                .addPlatform("Twitter")
                .setIncludesVisualLayout(false)
                .setBudget(100.0)
                .build();
        System.out.println("Client Custom Build: " + customCampaign);
    }
}