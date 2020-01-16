/*    */ 
/*    */ public class ItemCup
/*    */   extends sv
/*    */ {
/*    */   private int isFull;
/*    */   
/*    */   public ItemCup(int i, int j) {
/*  8 */     super(i);
/*  9 */     this.bs = 1;
/* 10 */     this.isFull = j;
/*    */   }
/*    */ 
/*    */   
/*    */   public ul a(ul itemstack, rv world, sz entityplayer) {
/* 15 */     float f = 1.0F;
/* 16 */     float f1 = entityplayer.x + (entityplayer.v - entityplayer.x) * f;
/* 17 */     float f2 = entityplayer.w + (entityplayer.u - entityplayer.w) * f;
/* 18 */     double d = entityplayer.l + (entityplayer.o - entityplayer.l) * f;
/* 19 */     double d1 = entityplayer.m + (entityplayer.p - entityplayer.m) * f + 1.62D - entityplayer.H;
/* 20 */     double d2 = entityplayer.n + (entityplayer.q - entityplayer.n) * f;
/* 21 */     ax vec3d = ax.b(d, d1, d2);
/* 22 */     float f3 = et.b(-f2 * 0.01745329F - 3.141593F);
/* 23 */     float f4 = et.a(-f2 * 0.01745329F - 3.141593F);
/* 24 */     float f5 = -et.b(-f1 * 0.01745329F);
/* 25 */     float f6 = et.a(-f1 * 0.01745329F);
/* 26 */     float f7 = f4 * f5;
/* 27 */     float f8 = f6;
/* 28 */     float f9 = f3 * f5;
/* 29 */     double d3 = 5.0D;
/* 30 */     ax vec3d1 = vec3d.c(f7 * d3, f8 * d3, f9 * d3);
/* 31 */     ma movingobjectposition = world.a(vec3d, vec3d1, (this.isFull == 0));
/* 32 */     if (movingobjectposition == null)
/*    */     {
/* 34 */       return new ul(mod_tea.cup);
/*    */     }
/* 36 */     if (movingobjectposition.a == up.a) {
/*    */       
/* 38 */       int i = movingobjectposition.b;
/* 39 */       int j = movingobjectposition.c;
/* 40 */       int k = movingobjectposition.d;
/* 41 */       if (!world.a(entityplayer, i, j, k))
/*    */       {
/* 43 */         return itemstack;
/*    */       }
/* 45 */       if (this.isFull == 0)
/*    */       {
/* 47 */         if (world.f(i, j, k) == wa.g && world.e(i, j, k) == 0)
/*    */         {
/* 49 */           return new ul(mod_tea.cupWater);
/*    */         }
/*    */       }
/*    */     } 
/* 53 */     return new ul(mod_tea.cup);
/*    */   }
/*    */ }


/* Location:              /Users/taylorthurlow/Library/Mobile Documents/com~apple~CloudDocs/minecraftshit/Tea_v0.1_-_1.8.1/!/ItemCup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */