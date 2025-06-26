/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package prenotazioni.service.impl;

import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import prenotazioni.service.base.PrenotazioneServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=",
		"json.web.service.context.path=Prenotazione"
	},
	service = AopService.class
)
public class PrenotazioneServiceImpl extends PrenotazioneServiceBaseImpl {
}