package logic.business.abstractions;

import logic.business.Product;

public abstract class IDisc implements IProduct, ProductContainer{
	public abstract Product getItem(int index); //Puede ser q necesite ser movido este metodo para IProduct
}
