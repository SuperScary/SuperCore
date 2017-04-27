package superscary.supercore;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import superscary.supercore.client.cape.ICoreMod;
import superscary.supercore.info.Generator;
import superscary.supercore.logging.Logger;
import superscary.supercore.proxy.IProxy;
import superscary.supercore.resources.ModResources;

import java.util.ArrayList;

import static superscary.supercore.resources.ModResources.*;

@SuppressWarnings("unused")
@Mod(modid = MODID, version = VERSION, name = NAME)
public class SuperCore implements ICoreMod
{

    public static final String SET_REQUIRED_AFTER = "required-after:supercore@[1.0,)";
    public static final String SET_REQUIRED_AFTER_CUSTOM = "required-after:supercore@";

    private ArrayList<Modification> modifications = new ArrayList<>();

    @SidedProxy(clientSide = CLIENT_PROXY, serverSide = COMMON_PROXY)
    public static IProxy proxy;

    static
    {
        FluidRegistry.enableUniversalBucket();
        FluidRegistry.validateFluidRegistry();
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        Logger.setLogger(event.getModLog());
        Generator.Info.create(ModResources.class, event);

        proxy.preInit();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init();
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();

        for(ModContainer container : Loader.instance().getActiveModList())
        {
            modifications.add(new Modification(container));
        }

    }

    @Override
    public String modid()
    {
        return MODID;
    }

    @Override
    public ResourceLocation capeImageLocation()
    {
        return new ResourceLocation(MODID,"textures/cape/supercore.png");
    }

}
