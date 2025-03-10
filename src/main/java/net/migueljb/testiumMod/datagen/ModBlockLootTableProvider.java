package net.migueljb.testiumMod.datagen;

import net.migueljb.testiumMod.block.ModBlocks;
import net.migueljb.testiumMod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    public ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.DEFAULT_FLAGS, registries);
    }


    @Override
    protected void generate() {

        this.dropSelf(ModBlocks.TAINTER_BLOCK.get());
        this.dropSelf(ModBlocks.TESTIUMR_BLOCK.get());
        this.dropSelf(ModBlocks.TESTIUMG_BLOCK.get());
        /*
        this.add(ModBlocks.GREENIUM_ORE_BLOCK.get(),
                this.createOreDrop(ModBlocks.GREENIUM_ORE_BLOCK.get(),ModItems.GREENIUM.get()));
        this.add(ModBlocks.REDIUM_ORE_BLOCK.get(),
                this.createOreDrop(ModBlocks.REDIUM_ORE_BLOCK.get(),ModItems.REDIUM.get()));
*/
        this.add(ModBlocks.GREENIUM_ORE_BLOCK.get(),
                this.createMultipleOreDrops(ModBlocks.GREENIUM_ORE_BLOCK.get(), ModItems.GREENIUM.get(), 4, 6));
        this.add(ModBlocks.REDIUM_ORE_BLOCK.get(),
                this.createMultipleOreDrops(ModBlocks.REDIUM_ORE_BLOCK.get(), ModItems.REDIUM.get(), 1, 9));
        //this.dropSelf(ModBlocks.TESTIUMR_STAIRS.get());
        //this.add(ModBlocks.TESTIUMR_SLAB.get(),
        //        this.createSlabItemTable(ModBlocks.TESTIUMR_SLAB.get()));

        this.dropSelf(ModBlocks.TESTIUMR_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.TESTIUMG_PRESSURE_PLATE.get());
        //this.dropSelf(ModBlocks.TESTIUMR_BUTTON.get());
        //this.dropSelf(ModBlocks.TESTIUMR_FENCE.get());
        //this.dropSelf(ModBlocks.TESTIUMR_FENCE_GATE.get());
        //this.dropSelf(ModBlocks.TESTIUMR_WALL.get());
        //this.dropSelf(ModBlocks.TESTIUMR_TRAPDOOR.get());

        //this.add(ModBlocks.TESTIUMR_DOOR.get(),
        //        this.createDoorTable(ModBlocks.TESTIUMR_DOOR.get()));
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        // The contents of our DeferredRegister.
        return ModBlocks.BLOCKS.getEntries()
                .stream()
                // Cast to Block here, otherwise it will be a ? extends Block and Java will complain.
                .map(e -> (Block) e.value())
                .toList();
    }
}
