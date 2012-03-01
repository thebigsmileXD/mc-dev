package net.minecraft.server;

public class ContainerPlayer extends Container {

    public InventoryCrafting craftInventory;
    public IInventory resultInventory;
    public boolean c;

    public ContainerPlayer(PlayerInventory playerinventory) {
        this(playerinventory, true);
    }

    public ContainerPlayer(PlayerInventory playerinventory, boolean flag) {
        this.craftInventory = new InventoryCrafting(this, 2, 2);
        this.resultInventory = new InventoryCraftResult();
        this.c = false;
        this.c = flag;
        this.a((Slot) (new SlotResult(playerinventory.player, this.craftInventory, this.resultInventory, 0, 144, 36)));

        int i;
        int j;

        for (i = 0; i < 2; ++i) {
            for (j = 0; j < 2; ++j) {
                this.a(new Slot(this.craftInventory, j + i * 2, 88 + j * 18, 26 + i * 18));
            }
        }

        for (i = 0; i < 4; ++i) {
            this.a((Slot) (new SlotArmor(this, playerinventory, playerinventory.getSize() - 1 - i, 8, 8 + i * 18, i)));
        }

        for (i = 0; i < 3; ++i) {
            for (j = 0; j < 9; ++j) {
                this.a(new Slot(playerinventory, j + (i + 1) * 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.a(new Slot(playerinventory, i, 8 + i * 18, 142));
        }

        this.a((IInventory) this.craftInventory);
    }

    public void a(IInventory iinventory) {
        this.resultInventory.setItem(0, CraftingManager.getInstance().craft(this.craftInventory));
    }

    public void a(EntityHuman entityhuman) {
        super.a(entityhuman);

        for (int i = 0; i < 4; ++i) {
            ItemStack itemstack = this.craftInventory.splitWithoutUpdate(i);

            if (itemstack != null) {
                entityhuman.drop(itemstack);
            }
        }

        this.resultInventory.setItem(0, (ItemStack) null);
    }

    public boolean b(EntityHuman entityhuman) {
        return true;
    }

    public ItemStack a(int i) {
        ItemStack itemstack = null;
        Slot slot = (Slot) this.e.get(i);

        if (slot != null && slot.c()) {
            ItemStack itemstack1 = slot.getItem();

            itemstack = itemstack1.cloneItemStack();
            if (i == 0) {
                if (!this.a(itemstack1, 9, 45, true)) {
                    return null;
                }

                slot.a(itemstack1, itemstack);
            } else if (i >= 9 && i < 36) {
                if (!this.a(itemstack1, 36, 45, false)) {
                    return null;
                }
            } else if (i >= 36 && i < 45) {
                if (!this.a(itemstack1, 9, 36, false)) {
                    return null;
                }
            } else if (!this.a(itemstack1, 9, 45, false)) {
                return null;
            }

            if (itemstack1.count == 0) {
                slot.set((ItemStack) null);
            } else {
                slot.d();
            }

            if (itemstack1.count == itemstack.count) {
                return null;
            }

            slot.c(itemstack1);
        }

        return itemstack;
    }
}
