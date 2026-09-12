# SMM Campaign Builder

This project demonstrates the **Builder** creational design pattern in Java. It builds an `SmmCampaign` step by step, so a client can configure optional campaign details without using a long constructor.

The domain is social-media marketing. A campaign may have a name, target audience, one or more platforms, a budget, and an optional visual-layout plan. This is a suitable Builder example because campaigns can have different combinations of these settings and several reusable presets.

## Pattern participants

| Participant | Implementation | Responsibility |
| --- | --- | --- |
| Product | `SmmCampaign` | Represents the finished social-media marketing campaign. |
| Builder | `SmmCampaignBuilder` | Collects campaign settings and creates a valid `SmmCampaign`. |
| Director | `CampaignDirector` | Defines reusable construction sequences for standard campaign presets. |
| Client | `Main` | Requests preset and custom campaigns, then displays the results. |

## Included scenarios

`Main` demonstrates both ways of using the Builder:

1. The `CampaignDirector` creates an Instagram visual promotion and a cross-platform launch campaign.
2. The client uses `SmmCampaignBuilder` directly to create a custom Twitter campaign.

Each configuration uses method chaining: every builder method returns the same builder instance, making the construction sequence readable.

```java
SmmCampaign customCampaign = new SmmCampaignBuilder()
        .setCampaignName("Niche Twitter Thread")
        .setTargetAudience("Tech Enthusiasts")
        .addPlatform("Twitter")
        .setIncludesVisualLayout(false)
        .setBudget(100.0)
        .build();
```

## Project structure

```text
src/
├── Main.java                         # Client and program entry point
└── builder/
    ├── SmmCampaign.java              # Product
    ├── SmmCampaignBuilder.java       # Concrete builder
    └── CampaignDirector.java         # Reusable build sequences
```

## How to run


In IntelliJ IDEA, open the project and run the `main` method in `src/Main.java`.

## Clean Code principles applied

### 1. Meaningful, intention-revealing names

Class, method, and field names explain their purpose without abbreviations or vague labels. For example, `setIncludesVisualLayout` communicates exactly which option is being configured.

```java
public SmmCampaignBuilder setIncludesVisualLayout(boolean includesVisualLayout) {
    this.includesVisualLayout = includesVisualLayout;
    return this;
}
```

### 2. Validated construction with clear errors

The `build()` method prevents creation of a campaign without a name or with an insufficient budget. The exception messages tell the client exactly what must be fixed.

```java
if (campaignName == null || campaignName.trim().isEmpty()) {
    throw new IllegalStateException("Campaign name must be specified.");
}
if (budget < MINIMUM_BUDGET) {
    throw new IllegalStateException("Budget must be at least $" + MINIMUM_BUDGET);
}
```

### 3. No magic numbers

The minimum budget has a named constant instead of embedding `50.0` inside the validation condition. This makes the business rule easy to find and change.

```java
private static final double MINIMUM_BUDGET = 50.0;

if (budget < MINIMUM_BUDGET) {
    throw new IllegalStateException("Budget must be at least $" + MINIMUM_BUDGET);
}
```

### 4. Small, focused classes and methods

Responsibilities are separated: the Director only defines known configurations, while the Builder performs configuration and creates the product. The focused `constructInstagramVisualPromo` method contains one reusable build sequence.

```java
public void constructInstagramVisualPromo(SmmCampaignBuilder builder) {
    builder.setCampaignName("Insta Aesthetic Promo")
            .setTargetAudience("Gen Z & Millennials")
            .addPlatform("Instagram")
            .setIncludesVisualLayout(true)
            .setBudget(300.0);
}
```

### 5. Encapsulation and defensive copying

The product receives its own copy of the platform list. Therefore, later changes to the Builder's internal list cannot accidentally change an already-built campaign.

```java
SmmCampaign(String campaignName, String targetAudience, List<String> platforms,
            double budget, boolean includesVisualLayout) {
    this.campaignName = campaignName;
    this.targetAudience = targetAudience;
    this.platforms = new ArrayList<>(platforms);
    this.budget = budget;
    this.includesVisualLayout = includesVisualLayout;
}
```

