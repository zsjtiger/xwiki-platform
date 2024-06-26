/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.administration.api;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.evaluation.ObjectEvaluator;
import org.xwiki.evaluation.ObjectEvaluatorException;
import org.xwiki.evaluation.ObjectPropertyEvaluator;

import com.xpn.xwiki.objects.BaseObject;

/**
 * Evaluator for objects of class {@code XWiki.ConfigurableClass}.
 * Returns a Map storing the evaluated content for "heading" and "linkPrefix" properties.
 *
 * @version $Id$
 * @since 15.10.9
 * @since 16.3.0
 */
@Component
@Singleton
@Named(ConfigurableObjectEvaluator.ROLE_HINT)
public class ConfigurableObjectEvaluator implements ObjectEvaluator
{
    /**
     * The role hint of this component.
     */
    public static final String ROLE_HINT = "XWiki.ConfigurableClass";

    @Inject
    @Named("velocity")
    private ObjectPropertyEvaluator velocityPropertyEvaluator;

    @Override
    public Map<String, String> evaluate(BaseObject object) throws ObjectEvaluatorException
    {
        return this.velocityPropertyEvaluator.evaluateProperties(object, "heading", "linkPrefix");
    }
}
