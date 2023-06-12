package lk.ijse.computershop.bo.custom.impl;

import lk.ijse.computershop.bo.custom.ItemBO;
import lk.ijse.computershop.dao.DAOFactory;
import lk.ijse.computershop.dao.custom.ItemDAO;
import lk.ijse.computershop.dto.ItemDTO;
import lk.ijse.computershop.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemBOImpl implements ItemBO {

    private ItemDAO itemDAO= DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public List<ItemDTO> loadAllItems() throws SQLException {
        List<ItemDTO> itemDTOList=new ArrayList<>();
        List<Item> itemList=itemDAO.loadAll();
        for (Item i:itemList) {
            ItemDTO itemDTO=new ItemDTO(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand());
            itemDTOList.add(itemDTO);
        }
        return itemDTOList;
    }

    @Override
    public int saveItem(ItemDTO i) throws SQLException {
        return itemDAO.save(new Item(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand()));
    }

    @Override
    public ItemDTO searchItem(String code) throws SQLException {
        Item i= itemDAO.search(code);
        return new ItemDTO(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand());
    }

    @Override
    public int updateItem(ItemDTO i) throws SQLException {
        return itemDAO.update(new Item(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand()));
    }

    @Override
    public int deleteItem(String code) throws SQLException {
        return itemDAO.delete(code);
    }

    @Override
    public String generateNextItemCode() throws SQLException {
        return itemDAO.generateNextId();
    }

    @Override
    public List<String> loadItemCodes() throws SQLException {
        return itemDAO.loadItemCodes();
    }
}
