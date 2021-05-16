package com.gtnewhorizon.structurelib.alignment;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.FakePlayer;

public class AlignmentUtility {
    private AlignmentUtility(){
    }

    public static boolean handle(EntityPlayer aPlayer, World aWorld, int aX, int aY, int aZ){
        TileEntity tTileEntity = aWorld.getTileEntity(aX, aY, aZ);
        if(tTileEntity==null || aPlayer instanceof FakePlayer) {
            return aPlayer instanceof EntityPlayerMP;
        }
        if (aPlayer instanceof EntityPlayerMP) {
            /* TODO Make GT tile entity implement this interface and delegate all functionality to MTE
            if (tTileEntity instanceof IGregTechTileEntity) {
                IMetaTileEntity metaTE = ((IGregTechTileEntity) tTileEntity).getMetaTileEntity();
                if (metaTE instanceof IAlignmentProvider) {
                    IAlignment alignment = ((IAlignmentProvider) metaTE).getAlignment();
                    if(aPlayer.isSneaking()){
                        alignment.toolSetFlip(null);
                    }else {
                        alignment.toolSetRotation(null);
                    }
                    return true;
                }
            } else */ if (tTileEntity instanceof IAlignmentProvider) {
                IAlignment alignment = ((IAlignmentProvider) tTileEntity).getAlignment();
                if(aPlayer.isSneaking()){
                    alignment.toolSetFlip(null);
                }else {
                    alignment.toolSetRotation(null);
                }
                return true;
            }
        }
        return false;
    }
}
