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
    public int save(ItemDTO itemDTO) throws SQLException {
        return itemDAO.save(new Item(
                        itemDTO.getCode(),
                        itemDTO.getDescription(),
                        itemDTO.getUnitPrice(),
                        itemDTO.getQtyOnHand()
                )
        );
    }

    @Override
    public ItemDTO search(String code) throws SQLException {
        Item item=itemDAO.search(code);
        return new ItemDTO(item.getCode(),item.getDescription(),item.getUnitPrice(),item.getQtyOnHand());
    }

    @Override
    public int update(ItemDTO itemDTO) throws SQLException {
        return itemDAO.update(new Item(
                        itemDTO.getCode(),
                        itemDTO.getDescription(),
                        itemDTO.getUnitPrice(),
                        itemDTO.getQtyOnHand()
                )
        );
    }

    @Override
    public int delete(String code) throws SQLException {
        return itemDAO.delete(code);
    }

    @Override
    public List<ItemDTO> getAll() throws SQLException {
        List<ItemDTO> itemDTOList = new ArrayList<>();
        List<Item> items = itemDAO.getAll();
        for (Item i : items) {
            itemDTOList.add(new ItemDTO(i.getCode(),i.getDescription(),i.getUnitPrice(),i.getQtyOnHand()));
        }
        return itemDTOList;
    }

    @Override
    public String getNextId() throws SQLException {
        return itemDAO.getNextId();
    }

    @Override
    public List<String> loadCodes() throws SQLException {
        return itemDAO.loadCodes();
    }

    @Override
    public ItemDTO searchById(String itemCode) throws SQLException {
        return itemDAO.searchById(itemCode);
    }
}
