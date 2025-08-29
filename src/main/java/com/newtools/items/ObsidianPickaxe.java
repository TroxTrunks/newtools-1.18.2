package com.newtools.items;

import com.newtools.utils.ObsidianToolMaterial;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;

public class ObsidianPickaxe extends PickaxeItem {

    public ObsidianPickaxe(Settings settings) {
        super(ObsidianToolMaterial.INSTANCE, 1, -2.8F, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && miner instanceof PlayerEntity && state.getHardness(world, pos) != 0.0F) {
            PlayerEntity player = (PlayerEntity) miner;
            if (!player.isCreative()) {
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {
                        for (int z = -1; z <= 1; z++) {
                            if (x == 0 && y == 0 && z == 0) {
                                continue;
                            }
                            BlockPos newPos = pos.add(x, y, z);
                            BlockState newState = world.getBlockState(newPos);
                            if (stack.isSuitableFor(newState)) {
                                world.breakBlock(newPos, true, miner);
                            }
                        }
                    }
                }
            }
        }
        return super.postMine(stack, world, state, pos, miner);
    }
}
