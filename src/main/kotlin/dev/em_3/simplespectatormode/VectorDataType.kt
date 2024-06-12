package dev.em_3.simplespectatormode

import org.bukkit.Location
import org.bukkit.persistence.PersistentDataAdapterContext
import org.bukkit.persistence.PersistentDataType
import org.bukkit.util.Vector

class VectorDataType : PersistentDataType<Array<Double>, Vector> {
    override fun getPrimitiveType(): Class<Array<Double>> {
        return Array<Double>::class.java
    }

    override fun getComplexType(): Class<Vector> {
        return Vector::class.java
    }

    override fun fromPrimitive(primitive: Array<Double>, context: PersistentDataAdapterContext): Vector {
        return Vector(primitive[0], primitive[1], primitive[2])
    }

    override fun toPrimitive(complex: Vector, context: PersistentDataAdapterContext): Array<Double> {
        return arrayOf(complex.x, complex.y, complex.z)
    }
}