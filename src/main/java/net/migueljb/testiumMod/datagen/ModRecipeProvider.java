package net.migueljb.testiumMod.datagen;

import net.migueljb.testiumMod.TestiumMod;
import net.migueljb.testiumMod.block.ModBlocks;
import net.migueljb.testiumMod.item.ModItems;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider {
    protected ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() throws IllegalStateException {

        List<ItemLike> TESTIUMSMELTABLES = List.of(Items.ENDER_PEARL);
        List<ItemLike> GREENBEEFSMELTABLES = List.of(ModItems.RAW_GREEN_BEEF);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModBlocks.TAINTER_BLOCK.get())
                .pattern("AAA")
                .pattern("ABA")
                .pattern("AAA")
                .define('A', ModBlocks.TESTIUMR_BLOCK.get())
                .define('B', Items.ENDER_PEARL)
                .unlockedBy("has_testiumr", has(ModBlocks.TESTIUMR_BLOCK)).save(this.output);

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModItems.TESTIUMR.get(), 4)
                .requires(ModBlocks.TESTIUMR_BLOCK)
                .unlockedBy("has_testiumr_block", has(ModBlocks.TESTIUMR_BLOCK))
                .save(this.output, "testiummod:testiumr_from_block");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModItems.RED_COAL.get(), 1)
                .requires(ModItems.TESTIUMR)
                .requires(Items.COAL)
                .unlockedBy("has_testiumr", has(ModItems.TESTIUMR))
                .save(this.output);
        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModItems.RAW_GREEN_BEEF.get(), 1)
                .requires(Items.BEEF)
                .requires(ModItems.TESTIUMG)
                .unlockedBy("has_testiumg", has(ModItems.TESTIUMG))
                .save(this.output);
        //BUTTONS
        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, ModBlocks.TESTIUMR_BUTTON.get(), 1)
                .requires(ModBlocks.TESTIUMR_BLOCK.get())
                .unlockedBy("has_testiumr_block", has(ModBlocks.TESTIUMR_BLOCK))
                .save(this.output);
        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, ModBlocks.TESTIUMG_BUTTON.get(), 1)
                .requires(ModBlocks.TESTIUMG_BLOCK.get())
                .unlockedBy("has_testiumg_block", has(ModBlocks.TESTIUMG_BLOCK))
                .save(this.output);
        //STAIRS
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TESTIUMR_STAIRS.get())
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.TESTIUMR_BLOCK.get())
                .unlockedBy("has_testiumr_block", has(ModBlocks.TESTIUMR_BLOCK)).save(this.output);
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TESTIUMG_STAIRS.get())
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.TESTIUMG_BLOCK.get())
                .unlockedBy("has_testiumg_block", has(ModBlocks.TESTIUMG_BLOCK)).save(this.output);
        //TESTIUM RED BLOCK
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModBlocks.TESTIUMR_BLOCK.get())
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.TESTIUMR.get())
                .unlockedBy("has_testiumr", has(ModBlocks.TESTIUMR_BLOCK)).save(this.output);
        //TESTIUM GREEN BLOCK
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModBlocks.TESTIUMG_BLOCK.get())
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.TESTIUMG.get())
                .unlockedBy("has_testiumr", has(ModBlocks.TESTIUMG_BLOCK)).save(this.output);
        //PRESSURE PLATES
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, ModBlocks.TESTIUMR_PRESSURE_PLATE.get())
                .pattern("AA")
                .define('A', ModBlocks.TESTIUMR_BLOCK.get())
                .unlockedBy("has_testiumr_block", has(ModBlocks.TESTIUMR_PRESSURE_PLATE)).save(this.output);
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, ModBlocks.TESTIUMG_PRESSURE_PLATE.get())
                .pattern("AA")
                .define('A', ModBlocks.TESTIUMG_BLOCK.get())
                .unlockedBy("has_testiumg_block", has(ModBlocks.TESTIUMG_PRESSURE_PLATE)).save(this.output);
        //SLABS
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TESTIUMR_SLAB.get())
                .pattern("AAA")
                .define('A', ModBlocks.TESTIUMR_BLOCK.get())
                .unlockedBy("has_testiumr_block", has(ModBlocks.TESTIUMR_SLAB)).save(this.output);
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TESTIUMG_SLAB.get())
                .pattern("AAA")
                .define('A', ModBlocks.TESTIUMG_BLOCK.get())
                .unlockedBy("has_testiumg_block", has(ModBlocks.TESTIUMG_SLAB)).save(this.output);
        //FENCES
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, ModBlocks.TESTIUMR_FENCE.get())
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TESTIUMR.get())
                .unlockedBy("has_testiumr", has(ModBlocks.TESTIUMR_FENCE)).save(this.output);
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, ModBlocks.TESTIUMG_FENCE.get())
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.TESTIUMG.get())
                .unlockedBy("has_testiumg", has(ModBlocks.TESTIUMG_FENCE)).save(this.output);
        //Fence Gates
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, ModBlocks.TESTIUMR_FENCE_GATE.get())
                .pattern("ABA")
                .pattern("ABA")
                .define('A', ModBlocks.TESTIUMR_BLOCK.get())
                .define('B', ModItems.TESTIUMR.get())
                .unlockedBy("has_testiumr_block", has(ModBlocks.TESTIUMR_FENCE_GATE)).save(this.output);
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, ModBlocks.TESTIUMG_FENCE_GATE.get())
                .pattern("ABA")
                .pattern("ABA")
                .define('A', ModBlocks.TESTIUMG_BLOCK.get())
                .define('B', ModItems.TESTIUMG.get())
                .unlockedBy("has_testiumg_block", has(ModBlocks.TESTIUMG_FENCE_GATE)).save(this.output);
        //Doors
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, ModBlocks.TESTIUMR_DOOR.get())
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.TESTIUMR.get())
                .unlockedBy("has_testiumr", has(ModBlocks.TESTIUMR_DOOR)).save(this.output);
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, ModBlocks.TESTIUMG_DOOR.get())
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.TESTIUMG.get())
                .unlockedBy("has_testiumg", has(ModBlocks.TESTIUMG_DOOR)).save(this.output);
        //TrapDoors
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, ModBlocks.TESTIUMR_TRAPDOOR.get())
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.TESTIUMR.get())
                .unlockedBy("has_testiumr", has(ModBlocks.TESTIUMR_TRAPDOOR)).save(this.output);
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.DECORATIONS, ModBlocks.TESTIUMG_TRAPDOOR.get())
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.TESTIUMG.get())
                .unlockedBy("has_testiumg", has(ModBlocks.TESTIUMG_TRAPDOOR)).save(this.output);

        //Walls
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TESTIUMR_WALL.get())
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.TESTIUMR_BLOCK.get())
                .unlockedBy("has_testiumr_block", has(ModBlocks.TESTIUMR_WALL)).save(this.output);
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TESTIUMG_WALL.get())
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.TESTIUMG_BLOCK.get())
                .unlockedBy("has_testiumg_block", has(ModBlocks.TESTIUMG_WALL)).save(this.output);

        //Lamp
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, ModBlocks.TESTIUM_LAMP.get())
                .pattern("BAB")
                .pattern("ABA")
                .pattern("BAB")
                .define('A', ModItems.TESTIUM.get())
                .define('B', Blocks.GLOWSTONE)
                .unlockedBy("has_testium", has(ModBlocks.TESTIUM_LAMP)).save(this.output);

        //Tools
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, ModItems.TESTIUM_HOE.get())
                .pattern("BB ")
                .pattern(" A ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.TESTIUM.get())
                .unlockedBy("has_testium", has(ModItems.TESTIUM_HOE)).save(this.output);
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, ModItems.TESTIUM_SWORD.get())
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.TESTIUM.get())
                .unlockedBy("has_testium", has(ModItems.TESTIUM_SWORD)).save(this.output);
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, ModItems.TESTIUM_PICKAXE.get())
                .pattern("BBB")
                .pattern(" A ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.TESTIUM.get())
                .unlockedBy("has_testium", has(ModItems.TESTIUM_PICKAXE)).save(this.output);
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, ModItems.TESTIUM_AXE.get())
                .pattern("BB ")
                .pattern("BA ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.TESTIUM.get())
                .unlockedBy("has_testium", has(ModItems.TESTIUM_AXE)).save(this.output);
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, ModItems.TESTIUM_SHOVEL.get())
                .pattern(" B ")
                .pattern(" A ")
                .pattern(" A ")
                .define('A', Items.STICK)
                .define('B', ModItems.TESTIUM.get())
                .unlockedBy("has_testium", has(ModItems.TESTIUM_SHOVEL)).save(this.output);

        oreSmelting2(TESTIUMSMELTABLES, RecipeCategory.MISC, ModItems.TESTIUM.get(), 0.45f, 1000, "testium");
        oreBlasting2(TESTIUMSMELTABLES, RecipeCategory.MISC, ModItems.TESTIUM.get(), 0.65f, 500, "testium");

        oreSmelting2(GREENBEEFSMELTABLES, RecipeCategory.MISC, ModItems.GREEN_BEEF.get(), 0.25f, 200, "greenbeef");

    }

    // The runner to add to the data generator
    public static class Runner extends RecipeProvider.Runner {
        @Override
        public String getName() {
            return "Mod Recipe Provider";
        }
        // Get the parameters from the `GatherDataEvent`s.
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
            super(output, lookupProvider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output) {
            return new ModRecipeProvider(provider, output);
        }
    }

    protected void oreSmelting2(List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group) {
        this.oreCooking2(
                RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, ingredients, category, result, experience, cookingTime, group, "_from_smelting"
        );
    }

    protected void oreBlasting2(List<ItemLike> ingredients, RecipeCategory category, ItemLike result, float experience, int cookingTime, String group) {
        this.oreCooking2(
                RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, ingredients, category, result, experience, cookingTime, group, "_from_blasting"
        );
    }

    protected <T extends AbstractCookingRecipe> void oreCooking2(
            RecipeSerializer<T> serializer,
            AbstractCookingRecipe.Factory<T> recipeFactory,
            List<ItemLike> ingredients,
            RecipeCategory category,
            ItemLike result,
            float experience,
            int cookingTime,
            String group,
            String suffix

    ) {
        for (ItemLike itemlike : ingredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), category, result, experience, cookingTime, serializer, recipeFactory)
                    .group(group)
                    .unlockedBy(getHasName(itemlike), this.has(itemlike))
                    .save(this.output, TestiumMod.MOD_ID + ":" +getItemName(result) + suffix + "_" + getItemName(itemlike));
        }
    }




}
