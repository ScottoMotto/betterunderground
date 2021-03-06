package com.wynprice.betterunderground.generation.biomeGen;

import java.util.Random;

import com.wynprice.betterunderground.Utils;
import com.wynprice.betterunderground.WorldGenBetterUnderGround;
import com.wynprice.betterunderground.generation.structureGen.DecorationHelper;
import com.wynprice.betterunderground.generation.structureGen.GenerateStoneStalactite;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public final class GenerationNormal extends WorldGenerator {
	public GenerationNormal() {
	}

	@Override
	public boolean generate(World world, Random random, BlockPos pos) {
		switch (Utils.weightedChoise(WorldGenBetterUnderGround.probabilityVines, WorldGenBetterUnderGround.probabilitySpiderWeb, WorldGenBetterUnderGround.probabilityStalactite, WorldGenBetterUnderGround.probabilityGlowcaps,
				WorldGenBetterUnderGround.probabilitySkulls, 0)) {
		case 1:
			DecorationHelper.generateVines(world, random, pos);
            return true;
		case 2:
			world.setBlockState(pos, Blocks.WEB.getDefaultState(), 2);
            return true;
		case 3:
            GenerateStoneStalactite g = new GenerateStoneStalactite();
            g.generate(world, random, pos, Utils.getNumEmptyBlocks(world, pos), WorldGenBetterUnderGround.maxLength);
            return true;
		case 4:
			DecorationHelper.generateGlowcaps(world, random, pos);
            return true;
		case 5:
			DecorationHelper.generateSkulls(world, random, pos, Utils.getNumEmptyBlocks(world, pos));
            return true;
		}
        return false;
	}
}
