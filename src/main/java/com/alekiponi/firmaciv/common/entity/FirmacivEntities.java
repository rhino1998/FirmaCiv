package com.alekiponi.firmaciv.common.entity;

import com.alekiponi.firmaciv.common.entity.vehicle.*;
import com.alekiponi.firmaciv.common.entity.vehiclehelper.*;
import com.alekiponi.firmaciv.common.entity.vehiclehelper.compartment.*;
import com.alekiponi.firmaciv.common.entity.vehiclehelper.compartment.vanilla.*;
import com.alekiponi.firmaciv.util.FirmacivHelper;
import com.alekiponi.firmaciv.util.FirmacivTags;
import net.dries007.tfc.util.registry.RegistryWood;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Locale;
import java.util.Map;

import static com.alekiponi.firmaciv.Firmaciv.MOD_ID;

public final class FirmacivEntities {

    private static final int LARGE_VEHICLE_TRACKING = 20;
    private static final int VEHICLE_HELPER_TRACKING = LARGE_VEHICLE_TRACKING + 1;
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES,
            MOD_ID);

    public static final Map<RegistryWood, RegistryObject<EntityType<CanoeEntity>>> CANOES = FirmacivHelper.TFCWoodMap(
            wood -> register("dugout_canoe/" + wood.getSerializedName(),
                    EntityType.Builder.of(CanoeEntity::new, MobCategory.MISC).sized(1.125F, 0.625F)));

    public static final Map<RegistryWood, RegistryObject<EntityType<RowboatEntity>>> ROWBOATS = FirmacivHelper.TFCWoodMap(
            wood -> register("rowboat/" + wood.getSerializedName(),
                    EntityType.Builder.of(RowboatEntity::new, MobCategory.MISC).sized(1.875F, 0.625F)));

    public static final RegistryObject<EntityType<KayakEntity>> KAYAK_ENTITY = register("kayak",
            EntityType.Builder.of(KayakEntity::new, MobCategory.MISC).sized(0.79F, 0.625F));

    public static final Map<RegistryWood, RegistryObject<EntityType<SloopEntity>>> SLOOPS = FirmacivHelper.TFCWoodMap(
            wood -> register("sloop/" + wood.getSerializedName(),
                    EntityType.Builder.of(SloopEntity::new, MobCategory.MISC).sized(3F, 0.75F)
                            .setTrackingRange(LARGE_VEHICLE_TRACKING).fireImmune()));

    /*
    public static final Map<BoatVariant, RegistryObject<EntityType<SloopConstructionEntity>>> SLOOPS_UNDER_CONSTRUCTION = Helpers.mapOfKeys(
            BoatVariant.class, variant -> register("sloop_construction/" + variant.getName(),
                    EntityType.Builder.of(SloopConstructionEntity::new, MobCategory.MISC).sized(3F, 0.75F)
                            .setTrackingRange(LARGE_VEHICLE_TRACKING).fireImmune()));
     */

    public static final Map<RegistryWood, RegistryObject<EntityType<SloopUnderConstructionEntity>>> SLOOPS_UNDER_CONSTRUCTION = FirmacivHelper.TFCWoodMap(
            wood -> register("sloop_construction/" + wood.getSerializedName(),
                    EntityType.Builder.<SloopUnderConstructionEntity>of((type, level) -> new SloopUnderConstructionEntity(type,level, wood), MobCategory.MISC).sized(4F, 0.75F)
                            .setTrackingRange(LARGE_VEHICLE_TRACKING).fireImmune().noSummon()));

    public static final RegistryObject<EntityType<EmptyCompartmentEntity>> EMPTY_COMPARTMENT_ENTITY = register(
            "compartment_empty",
            EntityType.Builder.of(EmptyCompartmentEntity::new, MobCategory.MISC).sized(0.6F, 0.7F).fireImmune()
                    .noSummon());

    public static final RegistryObject<CompartmentType<TFCChestCompartmentEntity>> TFC_CHEST_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_tfcchest",
            CompartmentType.Builder.of(TFCChestCompartmentEntity::new, TFCChestCompartmentEntity::new,
                    itemStack -> itemStack.is(FirmacivTags.Items.CHESTS), MobCategory.MISC));

    public static final RegistryObject<CompartmentType<BarrelCompartmentEntity>> BARREL_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_barrel", CompartmentType.Builder.of(BarrelCompartmentEntity::new, BarrelCompartmentEntity::new,
                    itemStack -> itemStack.is(Blocks.BARREL.asItem()), MobCategory.MISC));

    public static final RegistryObject<CompartmentType<ChestCompartmentEntity>> CHEST_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_chest", CompartmentType.Builder.of(ChestCompartmentEntity::new, ChestCompartmentEntity::new,
                    itemStack -> itemStack.is(Blocks.CHEST.asItem()), MobCategory.MISC));

    public static final RegistryObject<CompartmentType<EnderChestCompartmentEntity>> ENDER_CHEST_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_ender_chest",
            CompartmentType.Builder.of(EnderChestCompartmentEntity::new, EnderChestCompartmentEntity::new,
                    itemStack -> itemStack.is(Blocks.ENDER_CHEST.asItem()), MobCategory.MISC));

    public static final RegistryObject<CompartmentType<ShulkerBoxCompartmentEntity>> SHULKER_BOX_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_shulker_box",
            CompartmentType.Builder.of(ShulkerBoxCompartmentEntity::new, ShulkerBoxCompartmentEntity::new,
                    itemStack -> itemStack.is(FirmacivTags.Items.SHULKER_BOX), MobCategory.MISC));

    public static final RegistryObject<CompartmentType<FurnaceCompartmentEntity>> FURNACE_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_furnace",
            CompartmentType.Builder.of(FurnaceCompartmentEntity::new, FurnaceCompartmentEntity::new,
                    itemStack -> itemStack.is(Blocks.FURNACE.asItem()), MobCategory.MISC));

    public static final RegistryObject<CompartmentType<BlastFurnaceCompartmentEntity>> BLAST_FURNACE_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_blast_furnace",
            CompartmentType.Builder.of(BlastFurnaceCompartmentEntity::new, BlastFurnaceCompartmentEntity::new,
                    itemStack -> itemStack.is(Blocks.BLAST_FURNACE.asItem()), MobCategory.MISC));

    public static final RegistryObject<CompartmentType<SmokerCompartmentEntity>> SMOKER_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_smoker", CompartmentType.Builder.of(SmokerCompartmentEntity::new, SmokerCompartmentEntity::new,
                    itemStack -> itemStack.is(Blocks.SMOKER.asItem()), MobCategory.MISC));

    public static final RegistryObject<CompartmentType<WorkbenchCompartmentEntity>> WORKBENCH_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_workbench",
            CompartmentType.Builder.of(WorkbenchCompartmentEntity::new, WorkbenchCompartmentEntity::new,
                    itemStack -> itemStack.is(FirmacivTags.Items.WORKBENCHES), MobCategory.MISC));

    public static final RegistryObject<CompartmentType<StonecutterCompartmentEntity>> STONECUTTER_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_stonecutter",
            CompartmentType.Builder.of(StonecutterCompartmentEntity::new, StonecutterCompartmentEntity::new,
                    itemStack -> itemStack.is(Blocks.STONECUTTER.asItem()), MobCategory.MISC));

    public static final RegistryObject<CompartmentType<CartographyTableCompartmentEntity>> CARTOGRAPHY_TABLE_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_cartography_table",
            CompartmentType.Builder.of(CartographyTableCompartmentEntity::new, CartographyTableCompartmentEntity::new,
                    itemStack -> itemStack.is(Blocks.CARTOGRAPHY_TABLE.asItem()), MobCategory.MISC));

    public static final RegistryObject<CompartmentType<SmithingTableCompartmentEntity>> SMITHING_TABLE_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_smithing_table",
            CompartmentType.Builder.of(SmithingTableCompartmentEntity::new, SmithingTableCompartmentEntity::new,
                    itemStack -> itemStack.is(Blocks.SMITHING_TABLE.asItem()), MobCategory.MISC));

    public static final RegistryObject<CompartmentType<GrindstoneCompartmentEntity>> GRINDSTONE_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_grindstone",
            CompartmentType.Builder.of(GrindstoneCompartmentEntity::new, GrindstoneCompartmentEntity::new,
                    itemStack -> itemStack.is(Blocks.GRINDSTONE.asItem()), MobCategory.MISC));

    public static final RegistryObject<CompartmentType<LoomCompartmentEntity>> LOOM_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_loom", CompartmentType.Builder.of(LoomCompartmentEntity::new, LoomCompartmentEntity::new,
                    itemStack -> itemStack.is(Blocks.LOOM.asItem()), MobCategory.MISC));

    public static final RegistryObject<CompartmentType<AnvilCompartmentEntity>> ANVIL_COMPARTMENT_ENTITY = registerCompartment(
            "compartment_anvil", CompartmentType.Builder.of(AnvilCompartmentEntity::new, AnvilCompartmentEntity::new,
                    itemStack -> itemStack.is(FirmacivTags.Items.ANVILS), MobCategory.MISC));

    public static final RegistryObject<EntityType<BoatVehiclePart>> BOAT_VEHICLE_PART = register("vehicle_part_boat",
            EntityType.Builder.of(BoatVehiclePart::new, MobCategory.MISC).sized(0, 0)
                    .setTrackingRange(VEHICLE_HELPER_TRACKING).noSummon());

    public static final RegistryObject<EntityType<ConstructionVehiclePart>> CONSTRUCTION_VEHICLE_PART = register("vehicle_part_construction",
            EntityType.Builder.of(ConstructionVehiclePart::new, MobCategory.MISC).sized(0, 0)
                    .setTrackingRange(VEHICLE_HELPER_TRACKING).noSummon());

    public static final RegistryObject<EntityType<VehicleCleatEntity>> VEHICLE_CLEAT_ENTITY = register("vehicle_cleat",
            EntityType.Builder.of(VehicleCleatEntity::new, MobCategory.MISC).sized(0.4F, 0.2F)
                    .setTrackingRange(VEHICLE_HELPER_TRACKING).noSummon());

    public static final RegistryObject<EntityType<VehicleCollisionEntity>> VEHICLE_COLLISION_ENTITY = register(
            "vehicle_collider",
            EntityType.Builder.of(VehicleCollisionEntity::new, MobCategory.MISC).sized(1, 1).noSummon());

    public static final RegistryObject<EntityType<SailSwitchEntity>> SAIL_SWITCH_ENTITY = register(
            "vehicle_switch_sail",
            EntityType.Builder.of(SailSwitchEntity::new, MobCategory.MISC).sized(0.8F, 0.8F).noSummon());

    public static final RegistryObject<EntityType<AnchorEntity>> ANCHOR_ENTITY = register("vehicle_anchor",
            EntityType.Builder.of(AnchorEntity::new, MobCategory.MISC).sized(1, 1)
                    .clientTrackingRange(VEHICLE_HELPER_TRACKING).noSummon());

    public static final RegistryObject<EntityType<ConstructionEntity>> CONSTRUCTION_ENTITY = register("vehicle_construction",
            EntityType.Builder.of(ConstructionEntity::new, MobCategory.MISC).sized(1, 1)
                    .clientTrackingRange(VEHICLE_HELPER_TRACKING).noSummon());

    public static final RegistryObject<EntityType<WindlassSwitchEntity>> WINDLASS_SWITCH_ENTITY = register(
            "vehicle_switch_windlass",
            EntityType.Builder.of(WindlassSwitchEntity::new, MobCategory.MISC).sized(0.5F, 0.5F)
                    .setTrackingRange(VEHICLE_HELPER_TRACKING).noSummon());

    public static final RegistryObject<EntityType<CannonballEntity>> CANNONBALL_ENTITY = register("cannonball",
            EntityType.Builder.of(CannonballEntity::new, MobCategory.MISC).sized(0.5F, 0.5F).setTrackingRange(32)
                    .clientTrackingRange(32).noSummon());

    public static final RegistryObject<EntityType<CannonEntity>> CANNON_ENTITY = register("cannon",
            EntityType.Builder.of(CannonEntity::new, MobCategory.MISC).sized(0.8F, 0.8F));

    public static final RegistryObject<EntityType<MastEntity>> MAST_ENTITY = register("vehicle_mast",
            EntityType.Builder.of(MastEntity::new, MobCategory.MISC).sized(0.3F, 8)
                    .setTrackingRange(VEHICLE_HELPER_TRACKING).noSummon());

    private static <E extends AbstractCompartmentEntity> RegistryObject<CompartmentType<E>> registerCompartment(
            final String name, final CompartmentType.Builder<E> builder) {
        return registerCompartment(name, builder.sized(0.6F, 0.7F).fireImmune().noSummon(), true);
    }

    @SuppressWarnings("SameParameterValue")
    private static <E extends AbstractCompartmentEntity> RegistryObject<CompartmentType<E>> registerCompartment(
            final String name, final CompartmentType.Builder<E> builder, final boolean serialize) {
        final String id = name.toLowerCase(Locale.ROOT);
        return ENTITY_TYPES.register(id, () -> {
            if (!serialize) builder.noSave();
            return CompartmentType.register(builder.build(MOD_ID + ":" + id));
        });
    }

    private static <E extends Entity> RegistryObject<EntityType<E>> register(final String name,
            final EntityType.Builder<E> builder) {
        return register(name, builder, true);
    }

    @SuppressWarnings("SameParameterValue")
    private static <E extends Entity> RegistryObject<EntityType<E>> register(final String name,
            final EntityType.Builder<E> builder, final boolean serialize) {
        final String id = name.toLowerCase(Locale.ROOT);
        return ENTITY_TYPES.register(id, () -> {
            if (!serialize) builder.noSave();
            return builder.build(MOD_ID + ":" + id);
        });
    }
}