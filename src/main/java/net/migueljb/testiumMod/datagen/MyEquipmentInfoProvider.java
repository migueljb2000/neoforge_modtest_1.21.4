package net.migueljb.testiumMod.datagen;

import net.migueljb.testiumMod.TestiumMod;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.BiConsumer;

public class MyEquipmentInfoProvider implements DataProvider {

    private final PackOutput.PathProvider path;

    public MyEquipmentInfoProvider(PackOutput output) {
        this.path = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "equipment");

    }

    private void add(BiConsumer<ResourceLocation, EquipmentClientInfo> registrar) {
        registrar.accept(
                // Must match Equippable#assetId
                ResourceLocation.fromNamespaceAndPath("testiummod", "testium"),
                EquipmentClientInfo.builder()
                        // For humanoid head, chest, and feet
                        .addLayers(
                                EquipmentClientInfo.LayerType.HUMANOID,
                                // Base texture
                                new EquipmentClientInfo.Layer(
                                        // The relative texture of the armor
                                        // Points to assets/examplemod/textures/entity/equipment/copper/outer.png
                                        ResourceLocation.fromNamespaceAndPath("testiummod", "testium/testiumarmor"),
                                        Optional.empty(),
                                        false
                                )
                        )
                        // For humanoid legs
                        .addLayers(
                                EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS,
                                new EquipmentClientInfo.Layer(
                                        // Points to assets/examplemod/textures/entity/equipment/copper/inner.png
                                        ResourceLocation.fromNamespaceAndPath("testiummod", "testium/testiumarmorleggings"),
                                        Optional.empty(),
                                        false
                                )
                        )/*
                        // For wolf armor
                        .addLayers(
                                EquipmentClientInfo.LayerType.WOLF_BODY,
                                // Base texture
                                new EquipmentClientInfo.Layer(
                                        // Points to assets/examplemod/textures/entity/equipment/copper/wolf.png
                                        ResourceLocation.fromNamespaceAndPath("examplemod", "copper/wolf"),
                                        Optional.empty(),
                                        // When true, uses the texture passed into the layer renderer instead
                                        true
                                )
                        )*/
                        /*
                        // For horse armor
                        .addLayers(
                                EquipmentClientInfo.LayerType.HORSE_BODY,
                                // Base texture
                                new EquipmentClientInfo.Layer(
                                        // Points to assets/examplemod/textures/entity/equipment/copper/horse.png
                                        ResourceLocation.fromNamespaceAndPath("testium", "copper/horse"),
                                        Optional.empty(),
                                        true
                                )
                        )*/
                        .build()
        );
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        Map<ResourceLocation, EquipmentClientInfo> map = new HashMap<>();
        this.add((name, info) -> {
            if (map.putIfAbsent(name, info) != null) {
                throw new IllegalStateException("Tried to register equipment client info twice for id: " + name);
            }
        });
        return DataProvider.saveAll(cache, EquipmentClientInfo.CODEC, this.path, map);
    }

    @Override
    public String getName() {
        return "Equipment Client Infos: " + TestiumMod.MOD_ID;
    }
}


