package com.alekiponi.firmaciv.client;

import com.alekiponi.firmaciv.Firmaciv;
import com.alekiponi.firmaciv.client.model.entity.CanoeEntityModel;
import com.alekiponi.firmaciv.client.model.entity.KayakEntityModel;
import com.alekiponi.firmaciv.client.model.entity.RowboatEntityModel;
import com.alekiponi.firmaciv.client.render.entity.CannonRenderer;
import com.alekiponi.firmaciv.client.render.entity.CannonballRenderer;
import com.alekiponi.firmaciv.client.render.entity.vehicle.*;
import com.alekiponi.firmaciv.client.render.entity.vehicle.vehiclehelper.*;
import com.alekiponi.firmaciv.common.entity.FirmacivEntities;
import com.alekiponi.firmaciv.util.BoatVariant;
import com.alekiponi.firmaciv.util.FirmacivHelper;
import net.minecraft.client.renderer.entity.NoopRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Firmaciv.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class RenderEventHandler {

    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(CanoeEntityModel.LAYER_LOCATION, CanoeEntityModel::createBodyLayer);
        event.registerLayerDefinition(KayakEntityModel.LAYER_LOCATION, KayakEntityModel::createBodyLayer);
        event.registerLayerDefinition(RowboatEntityModel.LAYER_LOCATION, RowboatEntityModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        FirmacivHelper.forAllTFCWoods(wood -> {
            event.registerEntityRenderer(FirmacivEntities.CANOES.get(wood).get(),
                    context -> new CanoeRenderer(context, wood.getSerializedName()));
            event.registerEntityRenderer(FirmacivEntities.ROWBOATS.get(wood).get(),
                    context -> new RowboatRenderer(context, wood.getSerializedName()));
            event.registerEntityRenderer(FirmacivEntities.SLOOPS.get(wood).get(),
                    context -> new SloopRenderer(context, wood.getSerializedName()));
            event.registerEntityRenderer(FirmacivEntities.SLOOPS_UNDER_CONSTRUCTION.get(wood).get(),
                    context -> new SloopConstructionRenderer(context, wood.getSerializedName()));
        });

        event.registerEntityRenderer(FirmacivEntities.KAYAK_ENTITY.get(), KayakRenderer::new);

        event.registerEntityRenderer(FirmacivEntities.EMPTY_COMPARTMENT_ENTITY.get(), NoopRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.TFC_CHEST_COMPARTMENT_ENTITY.get(),
                BlockCompartmentRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.BARREL_COMPARTMENT_ENTITY.get(), BlockCompartmentRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.CHEST_COMPARTMENT_ENTITY.get(), ChestCompartmentRenderer::new);

        event.registerEntityRenderer(FirmacivEntities.ENDER_CHEST_COMPARTMENT_ENTITY.get(),
                EnderChestCompartmentRenderer::new);

        event.registerEntityRenderer(FirmacivEntities.SHULKER_BOX_COMPARTMENT_ENTITY.get(),
                ShulkerBoxCompartmentRenderer::new);

        event.registerEntityRenderer(FirmacivEntities.FURNACE_COMPARTMENT_ENTITY.get(), BlockCompartmentRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.BLAST_FURNACE_COMPARTMENT_ENTITY.get(),
                BlockCompartmentRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.SMOKER_COMPARTMENT_ENTITY.get(), BlockCompartmentRenderer::new);

        event.registerEntityRenderer(FirmacivEntities.WORKBENCH_COMPARTMENT_ENTITY.get(),
                BlockCompartmentRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.STONECUTTER_COMPARTMENT_ENTITY.get(),
                BlockCompartmentRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.CARTOGRAPHY_TABLE_COMPARTMENT_ENTITY.get(),
                BlockCompartmentRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.SMITHING_TABLE_COMPARTMENT_ENTITY.get(),
                BlockCompartmentRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.GRINDSTONE_COMPARTMENT_ENTITY.get(),
                BlockCompartmentRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.LOOM_COMPARTMENT_ENTITY.get(), BlockCompartmentRenderer::new);

        event.registerEntityRenderer(FirmacivEntities.ANVIL_COMPARTMENT_ENTITY.get(), BlockCompartmentRenderer::new);

        event.registerEntityRenderer(FirmacivEntities.BOAT_VEHICLE_PART.get(), NoopRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.CONSTRUCTION_VEHICLE_PART.get(), NoopRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.SAIL_SWITCH_ENTITY.get(), NoopRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.VEHICLE_COLLISION_ENTITY.get(), NoopRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.WINDLASS_SWITCH_ENTITY.get(), NoopRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.MAST_ENTITY.get(), NoopRenderer::new);

        event.registerEntityRenderer(FirmacivEntities.CANNONBALL_ENTITY.get(), CannonballRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.CANNON_ENTITY.get(), CannonRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.VEHICLE_CLEAT_ENTITY.get(), VehicleCleatRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.ANCHOR_ENTITY.get(), AnchorRenderer::new);
        event.registerEntityRenderer(FirmacivEntities.CONSTRUCTION_ENTITY.get(), ConstructionRenderer::new);
    }
}