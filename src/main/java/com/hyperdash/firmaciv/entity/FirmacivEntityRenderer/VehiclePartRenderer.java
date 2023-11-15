package com.hyperdash.firmaciv.entity.FirmacivEntityRenderer;

import com.hyperdash.firmaciv.entity.custom.CompartmentEntity.VehiclePartEntity;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class VehiclePartRenderer extends EntityRenderer<VehiclePartEntity> {
    public VehiclePartRenderer(EntityRendererProvider.Context pContext) {
        super(pContext);
    }

    @Override
    public ResourceLocation getTextureLocation(VehiclePartEntity pEntity) {
        return null;
    }

}
