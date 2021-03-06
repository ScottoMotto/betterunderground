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

public final class GenerationHumid extends WorldGenerator {
	public GenerationHumid() {
	}

	@Override
	public boolean generate(World world, Random random, BlockPos pos) {
		switch (Utils.weightedChoise(WorldGenBetterUnderGround.probabilityGlowcapsHumid, WorldGenBetterUnderGround.probabilityWet, WorldGenBetterUnderGround.probabilityVines, WorldGenBetterUnderGround.probabilitySpiderWeb,
				WorldGenBetterUnderGround.probabilitySkulls, WorldGenBetterUnderGround.probabilityStalactite)) {
		case 1:
			DecorationHelper.generateGlowcaps(world, random, pos);
			return true;
		case 2:
			DecorationHelper.generateFloodedCaves(world, random, pos);
			return true;
		case 3:
			DecorationHelper.generateVines(world, random, pos);
            return true;
		case 4:
			world.setBlockState(pos.down(Utils.getNumEmptyBlocks(world, pos) - 1), Blocks.WEB.getDefaultState(), 2);
            return true;
		case 5:
			DecorationHelper.generateSkulls(world, random, pos, Utils.getNumEmptyBlocks(world, pos));
            return true;
		default:
            new GenerateStoneStalactite().generate(world, random, pos, Utils.getNumEmptyBlocks(world, pos), WorldGenBetterUnderGround.maxLength);
            return true;
		}
	}
}
