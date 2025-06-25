package prenotazione.datasource;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.jdbc.DataSourceFactoryUtil;
import com.liferay.portal.kernel.dao.jdbc.DataSourceProvider;
import com.liferay.portal.util.PropsUtil;

@Component(
    immediate = true,
    service = DataSourceProvider.class,
    		property = {
    		        "data.source.name=prenotazioniDataSource"
    		    }
)
public class DataSourceProviderImpl implements DataSourceProvider {
	 
	@Override
	public DataSource getDataSource() {
 
		DataSource dataSource = null;
 
		try {
			
			dataSource = DataSourceFactoryUtil.initDataSource(PropsUtil.getProperties("jdbc.prenotazioni.jndi.name", true));
		}
		catch (Exception e) {
			e.printStackTrace();
		}
 
		return dataSource;
	}
}