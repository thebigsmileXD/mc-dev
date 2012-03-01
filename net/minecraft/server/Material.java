package net.minecraft.server;

public class Material {

    public static final Material AIR = new MaterialGas(MaterialMapColor.b);
    public static final Material GRASS = new Material(MaterialMapColor.c);
    public static final Material EARTH = new Material(MaterialMapColor.l);
    public static final Material WOOD = (new Material(MaterialMapColor.o)).f();
    public static final Material STONE = (new Material(MaterialMapColor.m)).e();
    public static final Material ORE = (new Material(MaterialMapColor.h)).e();
    public static final Material WATER = (new MaterialLiquid(MaterialMapColor.n)).m();
    public static final Material LAVA = (new MaterialLiquid(MaterialMapColor.f)).m();
    public static final Material LEAVES = (new Material(MaterialMapColor.i)).f().o().m();
    public static final Material PLANT = (new MaterialDecoration(MaterialMapColor.i)).m();
    public static final Material REPLACEABLE_PLANT = (new MaterialDecoration(MaterialMapColor.i)).f().m().h();
    public static final Material SPONGE = new Material(MaterialMapColor.e);
    public static final Material CLOTH = (new Material(MaterialMapColor.e)).f();
    public static final Material FIRE = (new MaterialGas(MaterialMapColor.b)).m();
    public static final Material SAND = new Material(MaterialMapColor.d);
    public static final Material ORIENTABLE = (new MaterialDecoration(MaterialMapColor.b)).m();
    public static final Material SHATTERABLE = (new Material(MaterialMapColor.b)).o();
    public static final Material BUILDABLE_GLASS = new Material(MaterialMapColor.b);
    public static final Material TNT = (new Material(MaterialMapColor.f)).f().o();
    public static final Material CORAL = (new Material(MaterialMapColor.i)).m();
    public static final Material ICE = (new Material(MaterialMapColor.g)).o();
    public static final Material SNOW_LAYER = (new MaterialDecoration(MaterialMapColor.j)).h().o().e().m();
    public static final Material SNOW_BLOCK = (new Material(MaterialMapColor.j)).e();
    public static final Material CACTUS = (new Material(MaterialMapColor.i)).o().m();
    public static final Material CLAY = new Material(MaterialMapColor.k);
    public static final Material PUMPKIN = (new Material(MaterialMapColor.i)).m();
    public static final Material DRAGON_EGG = (new Material(MaterialMapColor.i)).m();
    public static final Material PORTAL = (new MaterialPortal(MaterialMapColor.b)).n();
    public static final Material CAKE = (new Material(MaterialMapColor.b)).m();
    public static final Material WEB = (new MaterialWeb(MaterialMapColor.e)).e().m();
    public static final Material PISTON = (new Material(MaterialMapColor.m)).n();
    private boolean canBurn;
    private boolean H;
    private boolean I;
    public final MaterialMapColor F;
    private boolean J = true;
    private int K;

    public Material(MaterialMapColor materialmapcolor) {
        this.F = materialmapcolor;
    }

    public boolean isLiquid() {
        return false;
    }

    public boolean isBuildable() {
        return true;
    }

    public boolean blocksLight() {
        return true;
    }

    public boolean isSolid() {
        return true;
    }

    private Material o() {
        this.I = true;
        return this;
    }

    protected Material e() {
        this.J = false;
        return this;
    }

    protected Material f() {
        this.canBurn = true;
        return this;
    }

    public boolean isBurnable() {
        return this.canBurn;
    }

    public Material h() {
        this.H = true;
        return this;
    }

    public boolean isReplacable() {
        return this.H;
    }

    public boolean j() {
        return this.I ? false : this.isSolid();
    }

    public boolean isAlwaysDestroyable() {
        return this.J;
    }

    public int getPushReaction() {
        return this.K;
    }

    protected Material m() {
        this.K = 1;
        return this;
    }

    protected Material n() {
        this.K = 2;
        return this;
    }
}
