package com.wynprice.betterunderground.generation.structureGen;

import java.util.Random;

import com.wynprice.betterunderground.BetterUnderground;
import com.wynprice.betterunderground.Utils;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public final class GenerateSandstoneStalactites extends GenerateStoneStalactite{
    public GenerateSandstoneStalactites(){
        super(BetterUnderground.blockSandStalactite);
    }

    @Override
    protected void generateStalactiteBase(World world, Random random, BlockPos topY) {
        super.generateStalactiteBase(world, random, topY);
        Utils.convertToSandType(world, random, topY);
    }

    @Override
    protected boolean generateStalagmiteBase(World world, Random random, BlockPos botY, int aux) {
        if (world.getBlockState(botY.down()) == Blocks.STONE)
            world.setBlockState(botY.down(), Blocks.SANDSTONE.getDefaultState(), 2);
        boolean r = super.generateStalagmiteBase(world, random, botY, aux);
        Utils.convertToSandType(world, random, botY);
        return r;
    }
}
