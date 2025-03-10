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
                .define('A', ModItems.TESTIUMR.get())
                .unlockedBy("has_testiumr", has(ModBlocks.TESTIUMR_PRESSURE_PLATE)).save(this.output);
        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.REDSTONE, ModBlocks.TESTIUMG_PRESSURE_PLATE.get())
                .pattern("AA")
                .define('A', ModItems.TESTIUMG.get())
                .unlockedBy("has_testiumg", has(ModBlocks.TESTIUMG_PRESSURE_PLATE)).save(this.output);

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
