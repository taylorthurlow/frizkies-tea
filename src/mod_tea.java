/*     */ import net.minecraft.client.Minecraft;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class mod_tea
/*     */   extends BaseMod
/*     */ {
/*     */   @MLProp
/*  11 */   public static int idCup = 2921; @MLProp
/*  12 */   public static int idCupUnfired = 2922; @MLProp
/*  13 */   public static int idCupWater = 2923; @MLProp
/*  14 */   public static int idCupWaterBoiled = 2924; @MLProp
/*  15 */   public static int idTeabagGreen = 2925; @MLProp
/*  16 */   public static int idTeabagRed = 2926; @MLProp
/*  17 */   public static int idTeabagGrey = 2927; @MLProp
/*  18 */   public static int idTeaGreen = 2928; @MLProp
/*  19 */   public static int idTeaRed = 2929; @MLProp
/*  20 */   public static int idTeaGrey = 2930; @MLProp
/*  21 */   public static int idCocoa = 2931;
/*     */   @MLProp(info = "Number of ticks to prevent being poisoned after drinking Green Tea. 20 ticks = 1 second.", min = 1.0D)
/*  23 */   public static int numTicksImmune = 600; @MLProp(info = "Number of ticks to prevent the loss of any of the hunger bar. 20 ticks = 1 second.", min = 1.0D)
/*  24 */   public static int numTicksHunger = 1200;
/*     */ 
/*     */ 
/*     */   
/*  28 */   public static final sv cup = (new ItemCup(idCup, 0)).a("cup").e(1);
/*  29 */   public static final sv cupUnfired = (new sv(idCupUnfired)).a("cupUnfired");
/*  30 */   public static final sv cupWater = (new ItemCup(idCupWater, 1)).a("cupWater");
/*  31 */   public static final sv cupWaterBoiled = (new ItemCup(idCupWaterBoiled, 1)).a("cupWaterBoiled");
/*  32 */   public static final sv teabagGreen = (new sv(idTeabagGreen)).a("teabagGreen").e(8);
/*  33 */   public static final sv teabagRed = (new sv(idTeabagRed)).a("teabagRed").e(8);
/*  34 */   public static final sv teabagGrey = (new sv(idTeabagGrey)).a("teabagGrey").e(8);
/*  35 */   public static final sv teaGreen = (new ItemTea(idTeaGreen)).a("teaGreen");
/*  36 */   public static final sv teaRed = (new ItemTea(idTeaRed)).a("teaRed");
/*  37 */   public static final sv teaGrey = (new ItemTea(idTeaGrey)).a("teaGrey");
/*  38 */   public static final sv cocoa = (new ItemTea(idCocoa)).a("cocoa"); public static boolean isImmuneToPoison;
/*     */   public static int immuneToPoisonTime;
/*     */   
/*     */   public mod_tea() {
/*  42 */     ModLoader.SetInGameHook(this, true, true);
/*  43 */     immuneToPoisonTime = 0;
/*  44 */     isImmuneToPoison = false;
/*  45 */     noHungerTime = 0;
/*  46 */     noHunger = false;
/*     */ 
/*     */ 
/*     */     
/*  50 */     ModLoader.AddName(cup, "Cup");
/*  51 */     ModLoader.AddName(cupUnfired, "Unfired Cup");
/*  52 */     ModLoader.AddName(cupWater, "Cup of Water");
/*  53 */     ModLoader.AddName(cupWaterBoiled, "Cup of Hot Water");
/*  54 */     ModLoader.AddName(teabagGreen, "Green Teabag");
/*  55 */     ModLoader.AddName(teabagRed, "Red Teabag");
/*  56 */     ModLoader.AddName(teabagGrey, "Grey Teabag");
/*  57 */     ModLoader.AddName(teaGreen, "Cactus Green Tea");
/*  58 */     ModLoader.AddName(teaRed, "Rose Red Tea");
/*  59 */     ModLoader.AddName(teaGrey, "Sugary Tea");
/*  60 */     ModLoader.AddName(cocoa, "Hot Cocoa");
/*     */ 
/*     */ 
/*     */     
/*  64 */     cup.bt = ModLoader.addOverride("/gui/items.png", "/gfx/tea/cup.png");
/*  65 */     cupUnfired.bt = ModLoader.addOverride("/gui/items.png", "/gfx/tea/cupUnfired.png");
/*  66 */     cupWater.bt = ModLoader.addOverride("/gui/items.png", "/gfx/tea/cupWater.png");
/*  67 */     cupWaterBoiled.bt = ModLoader.addOverride("/gui/items.png", "/gfx/tea/cupWaterBoiled.png");
/*  68 */     teabagGreen.bt = ModLoader.addOverride("/gui/items.png", "/gfx/tea/teabagGreen.png");
/*  69 */     teabagRed.bt = ModLoader.addOverride("/gui/items.png", "/gfx/tea/teabagRed.png");
/*  70 */     teabagGrey.bt = ModLoader.addOverride("/gui/items.png", "/gfx/tea/teabagGrey.png");
/*  71 */     teaGreen.bt = ModLoader.addOverride("/gui/items.png", "/gfx/tea/teaGreen.png");
/*  72 */     teaRed.bt = ModLoader.addOverride("/gui/items.png", "/gfx/tea/teaRed.png");
/*  73 */     teaGrey.bt = ModLoader.addOverride("/gui/items.png", "/gfx/tea/teaGrey.png");
/*  74 */     cocoa.bt = ModLoader.addOverride("/gui/items.png", "/gfx/tea/cocoa.png");
/*     */ 
/*     */ 
/*     */     
/*  78 */     ModLoader.AddRecipe(new ul(cupUnfired, 1), new Object[] { "C C", " C ", Character.valueOf('C'), sv.aJ });
/*     */     
/*  80 */     ModLoader.AddRecipe(new ul(teabagGreen, 1), new Object[] { " S ", "LDL", "PPP", Character.valueOf('S'), sv.L, Character.valueOf('L'), lr.L, Character.valueOf('D'), new ul(sv.aX, 1, 2), Character.valueOf('P'), sv.aL });
/*     */     
/*  82 */     ModLoader.AddRecipe(new ul(teabagRed, 1), new Object[] { " S ", "LDL", "PPP", Character.valueOf('S'), sv.L, Character.valueOf('L'), lr.L, Character.valueOf('D'), new ul(sv.aX, 1, 1), Character.valueOf('P'), sv.aL });
/*     */     
/*  84 */     ModLoader.AddRecipe(new ul(teabagGrey, 1), new Object[] { " S ", "LRL", "PPP", Character.valueOf('S'), sv.L, Character.valueOf('L'), lr.L, Character.valueOf('R'), sv.aK, Character.valueOf('P'), sv.aL });
/*     */     
/*  86 */     ModLoader.AddRecipe(new ul(cocoa, 1), new Object[] { "C", "B", Character.valueOf('C'), new ul(sv.aX, 1, 3), Character.valueOf('B'), cupWaterBoiled });
/*     */     
/*  88 */     ModLoader.AddRecipe(new ul(teaGreen, 1), new Object[] { "T", "B", Character.valueOf('T'), teabagGreen, Character.valueOf('B'), cupWaterBoiled });
/*  89 */     ModLoader.AddRecipe(new ul(teaRed, 1), new Object[] { "T", "B", Character.valueOf('T'), teabagRed, Character.valueOf('B'), cupWaterBoiled });
/*  90 */     ModLoader.AddRecipe(new ul(teaGrey, 1), new Object[] { "T", "B", Character.valueOf('T'), teabagGrey, Character.valueOf('B'), cupWaterBoiled });
/*     */ 
/*     */ 
/*     */     
/*  94 */     ModLoader.AddSmelting(cupUnfired.br, new ul(cup, 1));
/*  95 */     ModLoader.AddSmelting(cupWater.br, new ul(cupWaterBoiled, 1));
/*     */   }
/*     */   
/*     */   public static int noHungerTime;
/*     */   
/*     */   public boolean OnTickInGame(float tick, Minecraft minecraft) {
/* 101 */     qs qs = (ModLoader.getMinecraftInstance()).h;
/*     */ 
/*     */ 
/*     */     
/* 105 */     immuneToPoisonTime++;
/* 106 */     if (immuneToPoisonTime >= numTicksImmune) {
/*     */       
/* 108 */       immuneToPoisonTime = 0;
/* 109 */       isImmuneToPoison = false;
/*     */     } 
/* 111 */     if (qs.a(ud.u) == true && isImmuneToPoison == true) cancelPoison((sz)qs);
/*     */ 
/*     */ 
/*     */     
/* 115 */     noHungerTime++;
/* 116 */     if (noHungerTime >= numTicksHunger) {
/*     */       
/* 118 */       noHungerTime = 0;
/* 119 */       noHunger = false;
/*     */     } 
/*     */     
/* 122 */     if (noHunger == true) {
/*     */       
/* 124 */       kc foodstats = (ModLoader.getMinecraftInstance()).h.at();
/* 125 */       if (foodstats.a() < ItemTea.hungerLevel)
/*     */       {
/* 127 */         foodstats.a(ItemTea.hungerLevel);
/*     */       }
/*     */     } 
/*     */     
/* 131 */     return true;
/*     */   }
/*     */   public static boolean noHunger; private long clock;
/*     */   
/*     */   public static void cancelPoison(sz entityplayer) {
/* 136 */     entityplayer.a(new ade(ud.u.H, 0, 0));
/*     */   }
/*     */   public String Version() {
/* 139 */     return "v0.1 for Beta 1.8.1";
/*     */   }
/*     */ }


/* Location:              /Users/taylorthurlow/Library/Mobile Documents/com~apple~CloudDocs/minecraftshit/Tea_v0.1_-_1.8.1/!/mod_tea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */