package logic.business.abstractions;

import logic.business.Product;

public interface IDisc extends IProduct{
	public abstract Product getItem(int index); //Puede ser q necesite ser movido este metodo para IProduct
}