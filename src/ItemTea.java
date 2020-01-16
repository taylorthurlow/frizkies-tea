/*    */ 
/*    */ 
/*    */ public class ItemTea
/*    */   extends sv
/*    */ {
/*    */   public static int hungerLevel;
/*    */   
/*    */   public ItemTea(int i) {
/*  9 */     super(i);
/* 10 */     this.bs = 1;
/* 11 */     hungerLevel = 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public ul a(ul itemstack, rv world, sz entityplayer) {
/* 16 */     if (itemstack.c == mod_tea.teaGreen.br && !mod_tea.isImmuneToPoison) {
/*    */       
/* 18 */       qs qs = (ModLoader.getMinecraftInstance()).h;
/* 19 */       mod_tea.cancelPoison(entityplayer);
/* 20 */       mod_tea.immuneToPoisonTime = 0;
/* 21 */       mod_tea.isImmuneToPoison = true;
/* 22 */       if (qs.a(ud.u))
/*    */       {
/* 24 */         mod_tea.cancelPoison(entityplayer);
/*    */       }
/* 26 */       return new ul(mod_tea.cup);
/*    */     } 
/*    */     
/* 29 */     if (itemstack.c == mod_tea.teaRed.br && !mod_tea.noHunger) {
/*    */       
/* 31 */       mod_tea.noHungerTime = 0;
/* 32 */       mod_tea.noHunger = true;
/* 33 */       kc foodstats = (ModLoader.getMinecraftInstance()).h.at();
/* 34 */       hungerLevel = foodstats.a();
/*    */       
/* 36 */       System.out.println("DEBUG: Red Tea used.");
/* 37 */       return new ul(mod_tea.cup);
/*    */     } 
/*    */     
/* 40 */     if (itemstack.c == mod_tea.teaGrey.br) {
/*    */       
/* 42 */       entityplayer.e(4);
/* 43 */       return new ul(mod_tea.cup);
/*    */     } 
/*    */     
/* 46 */     if (itemstack.c == mod_tea.cocoa.br) {
/*    */       
/* 48 */       int amountHealed = 20 - entityplayer.bz;
/* 49 */       entityplayer.e(amountHealed);
/* 50 */       kc foodstats = (ModLoader.getMinecraftInstance()).h.at();
/* 51 */       foodstats.a(20);
/* 52 */       return new ul(mod_tea.cup);
/*    */     } 
/*    */     
/* 55 */     return itemstack;
/*    */   }
/*    */ }


/* Location:              /Users/taylorthurlow/Library/Mobile Documents/com~apple~CloudDocs/minecraftshit/Tea_v0.1_-_1.8.1/!/ItemTea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */