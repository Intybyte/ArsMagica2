package am2.guis;

import am2.AMCore;
import am2.common.configuration.AMConfig;
import am2.common.configuration.sections.ConfigBeta;
import am2.guis.controls.GuiButtonVariableDims;
import am2.guis.controls.GuiSlideControl;
import am2.network.AMDataWriter;
import am2.network.AMNetHandler;
import am2.network.AMPacketIDs;
import am2.particles.AMParticle;
import am2.particles.ParticleController;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.StatCollector;

@SideOnly(Side.CLIENT)
public class AuraCustomizationMenu extends GuiScreen{

	/**
	 * The title string that is displayed in the top-center of the screen.
	 */
	protected String screenTitle = "Beta Particle Customization";

	private GuiButtonVariableDims btnParticleType;
	private GuiButtonVariableDims btnParticleBehaviour;
	private GuiButtonVariableDims btnParticleColorMode;
	private GuiSlideControl sliParticleRed;
	private GuiSlideControl sliParticleGreen;
	private GuiSlideControl sliParticleBlue;
	private GuiSlideControl sliParticleAlpha;
	private GuiSlideControl sliParticleScale;
	private GuiSlideControl sliParticleQuantity;
	private GuiSlideControl sliParticleDelay;
	private GuiSlideControl sliParticleSpeed;

	private GuiButton activeButton;

	private GuiScreen parent;

	public AuraCustomizationMenu(){
		this.mc = Minecraft.getMinecraft();
		this.parent = this.mc.currentScreen;
		this.fontRendererObj = Minecraft.getMinecraft().fontRenderer;
		ScaledResolution scaledresolution = new ScaledResolution(mc, mc.displayWidth, mc.displayHeight);
		this.width = scaledresolution.getScaledWidth();
		this.height = scaledresolution.getScaledHeight();
	}

	@Override
	public boolean doesGuiPauseGame(){
		return false;
	}

	@Override
	public void initGui(){
		ConfigBeta beta = AMConfig.getInstance().getBeta();
		btnParticleType = new GuiButtonVariableDims(10, 50, 40, AMParticle.particleTypes[beta.getAuraType()]);
		btnParticleBehaviour = new GuiButtonVariableDims(11, 50, 60, ParticleController.AuraControllerOptions[beta.getAuraBehaviour()]);
		btnParticleColorMode = new GuiButtonVariableDims(12, 50, 80, beta.isAuraDefaultColor() ? StatCollector.translateToLocal("am2.gui.default") : beta.isAuraRandomColor() ? StatCollector.translateToLocal("am2.gui.random") : StatCollector.translateToLocal("am2.gui.custom"));

		btnParticleType.setDimensions(80, 20);
		btnParticleBehaviour.setDimensions(80, 20);
		btnParticleColorMode.setDimensions(80, 20);

		sliParticleScale = new GuiSlideControl(14, width - 110, 40, 100, StatCollector.translateToLocal("am2.gui.scale"), beta.getAuraScale() * 10, 1f, 200f);
		sliParticleAlpha = new GuiSlideControl(15, width - 110, 60, 100, StatCollector.translateToLocal("am2.gui.alpha"), beta.getAuraAlpha() * 100, 1f, 100f);
		sliParticleRed = new GuiSlideControl(16, width - 110, 80, 100, StatCollector.translateToLocal("am2.gui.red"), (beta.getAuraColor() >> 16) & 0xFF, 0f, 255f);
		sliParticleRed.setInteger(true);
		sliParticleGreen = new GuiSlideControl(17, width - 110, 100, 100, StatCollector.translateToLocal("am2.gui.green"), (beta.getAuraColor() >> 8) & 0xFF, 0f, 255f);
		sliParticleGreen.setInteger(true);
		sliParticleBlue = new GuiSlideControl(18, width - 110, 120, 100, StatCollector.translateToLocal("am2.gui.blue"), beta.getAuraColor() & 0xFF, 0f, 255f);
		sliParticleBlue.setInteger(true);

		sliParticleQuantity = new GuiSlideControl(20, width - 110, 140, 100, StatCollector.translateToLocal("am2.gui.qty"), beta.getAuraQuantity(), 1, 5);
		sliParticleQuantity.setInteger(true);

		sliParticleDelay = new GuiSlideControl(21, width - 110, 160, 100, StatCollector.translateToLocal("am2.gui.delay"), beta.getAuraDelay(), 1, 100);
		sliParticleDelay.setInteger(true);

		sliParticleSpeed = new GuiSlideControl(22, width - 110, 180, 100, StatCollector.translateToLocal("am2.gui.speed"), beta.getAuraSpeed(), 0.05f, 10.0f);

		if (beta.isAuraDefaultColor() || beta.isAuraRandomColor()){
			sliParticleRed.enabled = false;
			sliParticleBlue.enabled = false;
			sliParticleGreen.enabled = false;
		}else{
			sliParticleRed.enabled = true;
			sliParticleBlue.enabled = true;
			sliParticleGreen.enabled = true;
		}


		this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height - 28, StatCollector.translateToLocal("am2.gui.done")));

		this.buttonList.add(btnParticleType);
		this.buttonList.add(btnParticleBehaviour);
		this.buttonList.add(btnParticleColorMode);
		this.buttonList.add(sliParticleScale);
		this.buttonList.add(sliParticleAlpha);
		this.buttonList.add(sliParticleRed);
		this.buttonList.add(sliParticleGreen);
		this.buttonList.add(sliParticleBlue);
		this.buttonList.add(sliParticleDelay);
		this.buttonList.add(sliParticleQuantity);
		this.buttonList.add(sliParticleSpeed);
	}

	@Override
	public void drawScreen(int par1, int par2, float par3){
		this.drawDefaultBackground();
		drawCenteredString(fontRendererObj, screenTitle, width / 2, 4, 0xffffff);
		drawString(fontRendererObj, StatCollector.translateToLocal("am2.gui.type"), 10, 45, 0xffffff);
		drawString(fontRendererObj, StatCollector.translateToLocal("am2.gui.action"), 10, 65, 0xffffff);
		drawString(fontRendererObj, StatCollector.translateToLocal("am2.gui.color"), 10, 85, 0xffffff);
		drawString(fontRendererObj, StatCollector.translateToLocal("am2.gui.border"), 10, 105, 0xffffff);
		super.drawScreen(par1, par2, par3);
	}

	@Override
	protected void actionPerformed(GuiButton par1GuiButton){
		ConfigBeta beta = AMConfig.getInstance().getBeta();

		int index = 0;
		boolean flag = false;

		activeButton = par1GuiButton;

		switch (par1GuiButton.id){
		case 10: //particle type
			index = beta.getAuraType();
			index++;
			if (index >= AMParticle.particleTypes.length) index = 0;

			beta.setAuraType(index);
			btnParticleType.displayString = AMParticle.particleTypes[index];
			break;
		case 11: //particle behaviour
			index = beta.getAuraBehaviour();
			index++;
			if (index >= ParticleController.AuraControllerOptions.length) index = 0;
			beta.setAuraBehaviour(index);
			btnParticleBehaviour.displayString = ParticleController.AuraControllerOptions[index];
			break;
		case 12: //default color
		case 13: //random color
			if (beta.isAuraDefaultColor()){
				beta.setAuraDefaultColor(false);
				beta.setAuraRandomColor(true);
				sliParticleRed.enabled = false;
				sliParticleBlue.enabled = false;
				sliParticleGreen.enabled = false;
			}else if (beta.isAuraRandomColor()){
				beta.setAuraDefaultColor(false);
				beta.setAuraRandomColor(false);
				sliParticleRed.enabled = true;
				sliParticleBlue.enabled = true;
				sliParticleGreen.enabled = true;
			}else{
				beta.setAuraDefaultColor(true);
				beta.setAuraRandomColor(false);
				sliParticleRed.enabled = false;
				sliParticleBlue.enabled = false;
				sliParticleGreen.enabled = false;
			}
			btnParticleColorMode.displayString = beta.isAuraDefaultColor() ? "Default" : beta.isAuraRandomColor() ? StatCollector.translateToLocal("am2.gui.random") : StatCollector.translateToLocal("am2.gui.custom");
			break;
		case 14: //scale
			beta.setAuraScale(((GuiSlideControl)par1GuiButton).getShiftedValue() / 10f);
			break;
		case 15: //alpha
			beta.setAuraAlpha(((GuiSlideControl)par1GuiButton).getShiftedValue() / 100f);
			break;
		case 16: //red
		case 17: //green
		case 18: //blue
			int color = ((int)sliParticleRed.getShiftedValue() & 0xFF) << 16 | ((int)sliParticleGreen.getShiftedValue() & 0xFF) << 8 | (int)sliParticleBlue.getShiftedValue() & 0xFF;
			beta.setAuraColor(color);
			break;
		case 20: //quantity
			beta.setAuraQuantity((int)sliParticleQuantity.getShiftedValue());
			break;
		case 21: //delay
			beta.setAuraDelay((int)sliParticleDelay.getShiftedValue());
			break;
		case 22: //speed
			beta.setAuraSpeed(sliParticleSpeed.getShiftedValue());
			break;
		case 200: //close
			this.mc.displayGuiScreen(this.parent);
			break;
		}
	}

	@Override
	public void onGuiClosed(){
		ConfigBeta beta = AMConfig.getInstance().getBeta();
		AMDataWriter writer = new AMDataWriter();

		writer.add(beta.getAuraType());
		writer.add(beta.getAuraBehaviour());
		writer.add(beta.getAuraScale());
		writer.add(beta.getAuraAlpha());
		writer.add(beta.isAuraRandomColor());
		writer.add(beta.isAuraDefaultColor());
		writer.add(beta.getAuraColor());
		writer.add(beta.getAuraDelay());
		writer.add(beta.getAuraQuantity());
		writer.add(beta.getAuraSpeed());

		byte[] data = writer.generate();

		AMNetHandler.INSTANCE.sendPacketToServer(AMPacketIDs.SYNC_BETA_PARTICLES, data);

		AMConfig.save();

		super.onGuiClosed();
	}

	@Override
	protected void mouseMovedOrUp(int par1, int par2, int par3){
		if (activeButton != null && activeButton instanceof GuiSlideControl){
			actionPerformed(activeButton);
		}

		super.mouseMovedOrUp(par1, par2, par3);
	}

	@Override
	protected void mouseClicked(int x, int y, int button){
		ConfigBeta beta = AMConfig.getInstance().getBeta();
		GuiButton clickedBtn = getControlByXY(x, y);

		if (clickedBtn != null && button == 1){
			if (clickedBtn.id == 10){
				int index = beta.getAuraType();

				do {
					index--;
					if(index < 0) index = AMParticle.particleTypes.length - 1;
				} while(AMParticle.particleTypes[index].startsWith("lightning_bolt") && AMCore.proxy.playerTracker.getAAL(Minecraft.getMinecraft().thePlayer) < 3);

				beta.setAuraType(index);
				btnParticleType.displayString = AMParticle.particleTypes[index];
			}else if (clickedBtn.id == 11){
				int index = beta.getAuraBehaviour();
				index--;
				if (index < 0) index = ParticleController.AuraControllerOptions.length - 1;
				beta.setAuraBehaviour(index);
				btnParticleBehaviour.displayString = ParticleController.AuraControllerOptions[index];
			}
		}
		super.mouseClicked(x, y, button);
	}

	private GuiButton getControlByXY(int x, int y){
		for (Object btn : this.buttonList){
			if (btn instanceof GuiButton){
				GuiButton button = (GuiButton)btn;
				if (button.mousePressed(mc, x, y))
					return button;
			}
		}
		return null;
	}
}


