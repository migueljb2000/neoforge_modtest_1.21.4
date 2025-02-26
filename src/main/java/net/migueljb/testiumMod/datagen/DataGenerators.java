package net.migueljb.testiumMod.datagen;

import net.migueljb.testiumMod.TestiumMod;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.List;
import java.util.Set;

@EventBusSubscriber(modid = TestiumMod.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gaterData(GatherDataEvent.Client event){
        event.createProvider((output, lookupProvider) ->
                new LootTableProvider(output,
                // A set of required table resource locations. These are later verified to be present.
                // It is generally not recommended for mods to validate existence,
                // therefore we pass in an empty set.
                Set.of(),
                // A list of sub provider entries. See below for what values to use here.
                List.of(new LootTableProvider.SubProviderEntry(
                        ModBlockLootTableProvider::new,
                        LootContextParamSets.BLOCK // it makes sense to use BLOCK here
                )), lookupProvider
                ));
        event.createProvider(ModBlockModelProvider::new);
        //event.createProvider(ModBlockTagProvider::new);
        event.createBlockAndItemTags(ModBlockTagProvider::new, ModItemTagProvider:: new);
    }
}
