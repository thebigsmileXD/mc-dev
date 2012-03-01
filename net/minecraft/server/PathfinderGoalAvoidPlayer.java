package net.minecraft.server;

import java.util.List;

public class PathfinderGoalAvoidPlayer extends PathfinderGoal {

    private EntityCreature a;
    private float b;
    private float c;
    private Entity d;
    private float e;
    private PathEntity f;
    private Navigation g;
    private Class h;

    public PathfinderGoalAvoidPlayer(EntityCreature entitycreature, Class oclass, float f, float f1, float f2) {
        this.a = entitycreature;
        this.h = oclass;
        this.e = f;
        this.b = f1;
        this.c = f2;
        this.g = entitycreature.ak();
        this.a(1);
    }

    public boolean a() {
        if (this.h == EntityHuman.class) {
            if (this.a instanceof EntityTameableAnimal && ((EntityTameableAnimal) this.a).isTamed()) {
                return false;
            }

            this.d = this.a.world.findNearbyPlayer(this.a, (double) this.e);
            if (this.d == null) {
                return false;
            }
        } else {
            List list = this.a.world.a(this.h, this.a.boundingBox.grow((double) this.e, 3.0D, (double) this.e));

            if (list.size() == 0) {
                return false;
            }

            this.d = (Entity) list.get(0);
        }

        if (!this.a.al().canSee(this.d)) {
            return false;
        } else {
            Vec3D vec3d = RandomPositionGenerator.b(this.a, 16, 7, Vec3D.create(this.d.locX, this.d.locY, this.d.locZ));

            if (vec3d == null) {
                return false;
            } else if (this.d.e(vec3d.a, vec3d.b, vec3d.c) < this.d.j(this.a)) {
                return false;
            } else {
                this.f = this.g.a(vec3d.a, vec3d.b, vec3d.c);
                return this.f == null ? false : this.f.a(vec3d);
            }
        }
    }

    public boolean b() {
        return !this.g.e();
    }

    public void c() {
        this.g.a(this.f, this.b);
    }

    public void d() {
        this.d = null;
    }

    public void e() {
        if (this.a.j(this.d) < 49.0D) {
            this.a.ak().a(this.c);
        } else {
            this.a.ak().a(this.b);
        }
    }
}
