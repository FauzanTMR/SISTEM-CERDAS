package com.darskhandev.nassdek;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0006HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/darskhandev/nassdek/Order;", "", "items", "", "", "price", "", "(Ljava/util/List;I)V", "getItems", "()Ljava/util/List;", "getPrice", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Order.kt */
public final class Order {
    private final List<String> items;
    private final int price;

    public static /* synthetic */ Order copy$default(Order order, List<String> list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = order.items;
        }
        if ((i2 & 2) != 0) {
            i = order.price;
        }
        return order.copy(list, i);
    }

    public final List<String> component1() {
        return this.items;
    }

    public final int component2() {
        return this.price;
    }

    public final Order copy(List<String> list, int i) {
        Intrinsics.checkNotNullParameter(list, "items");
        return new Order(list, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Order)) {
            return false;
        }
        Order order = (Order) obj;
        return Intrinsics.areEqual((Object) this.items, (Object) order.items) && this.price == order.price;
    }

    public int hashCode() {
        return (this.items.hashCode() * 31) + Integer.hashCode(this.price);
    }

    public String toString() {
        return "Order(items=" + this.items + ", price=" + this.price + ')';
    }

    public Order(List<String> list, int i) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.items = list;
        this.price = i;
    }

    public final List<String> getItems() {
        return this.items;
    }

    public final int getPrice() {
        return this.price;
    }
}
