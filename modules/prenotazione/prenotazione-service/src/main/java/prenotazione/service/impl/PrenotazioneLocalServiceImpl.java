package prenotazione.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Order;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;

import org.osgi.service.component.annotations.Component;
import prenotazione.model.Prenotazione;
import prenotazione.service.base.PrenotazioneLocalServiceBaseImpl;

import java.util.List;

/**
 * Implementazione custom del service locale Prenotazione.
 */
@Component(
    property = "model.class.name=prenotazione.model.Prenotazione",
    service = AopService.class
)
public class PrenotazioneLocalServiceImpl extends PrenotazioneLocalServiceBaseImpl {

    @Override
    public List<Prenotazione> getPrenotazionesOrdered(String orderByCol, String orderByType) {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Prenotazione.class, getClass().getClassLoader());

        Order order;
        if ("data".equals(orderByCol)) {
            if ("asc".equalsIgnoreCase(orderByType)) {
                order = OrderFactoryUtil.asc("data");
            } else {
                order = OrderFactoryUtil.desc("data");
            }
        } else {
            order = OrderFactoryUtil.asc("prenotazioneId");
        }

        query.addOrder(order);

        return dynamicQuery(query);
    }
}
