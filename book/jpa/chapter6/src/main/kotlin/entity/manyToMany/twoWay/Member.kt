package entity.manyToMany.twoWay

import javax.persistence.*

@Entity
open class Member {

    @Id
    @Column(name = "MEMBER_ID")
    open var id: String? = null

    open var username: String? = null

    @ManyToMany
    @JoinTable(
        name = "MEMBER_PRODUCT",
        joinColumns = [JoinColumn(name = "MEMBER_ID")],
        inverseJoinColumns = [JoinColumn(name = "PRODUCT_ID")]
    )
    open var products: MutableList<Product> = mutableListOf()

    fun addProduct(product: Product) {
        products.add(product)
        product.members.add(this)
    }
}