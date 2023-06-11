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

    private ItemDAO itemDAO = DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public int saveItem(ItemDTO itemDTO) throws SQLException {
        return itemDAO.save(new Item(
                        itemDTO.getCode(),
                        itemDTO.getDescription(),
                        itemDTO.getUnitPrice(),
                        itemDTO.getQtyOnHand()
                )
        );
    }

    @Override
    public ItemDTO searchItem(String itemCode) throws SQLException {
        Item item=itemDAO.search(itemCode);
        return new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
    }

    @Override
    public int updateItem(ItemDTO itemDTO) throws SQLException {
        return itemDAO.update(new Item(
                        itemDTO.getCode(),
                        itemDTO.getDescription(),
                        itemDTO.getUnitPrice(),
                        itemDTO.getQtyOnHand()
                )
        );
    }

    @Override
    public int deleteItem(String itemCode) throws SQLException {
        return itemDAO.delete(itemCode);
    }

    @Override
    public List<ItemDTO> loadAllItems() throws SQLException {
        List<ItemDTO> itemDTOList = new ArrayList<>();
        List<Item> items = itemDAO.loadAll();
        for (Item i : items) {
            itemDTOList.add(new ItemDTO(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand()));
        }
        return itemDTOList;
    }

    @Override
    public String generateNextItemCode() throws SQLException {
        return itemDAO.generateNextId();
    }

    @Override
    public List<String> loadItemCodes() throws SQLException {
        return itemDAO.loadItemCodes();
    }

    @Override
    public ItemDTO searchByItemCode(String itemCode) throws SQLException {
        return itemDAO.searchByItemCode(itemCode);
    }
}
