<#macro parameters parameters>
    <#list parameters as parameter>${parameter.type} ${parameter.name}<#if parameter_has_next>, </#if></#list>
</#macro>

<#macro methodImplementatoin method>
    <#if method.implementation??>
        ${method.implementation}
    <#elseif method.returnType??>
        return null;
    </#if>
</#macro>

<#macro modifiers list>
    <#list list as modifier>${modifier}<#if modifier_has_next> </#if></#list><#t>
</#macro>

<#macro returnType method>
    <#compress>
        ${(method.returnType.name) ! "void"}
    </#compress>
</#macro>

<#macro parameters list>
    <#list list as parameter>${parameter.type.name} ${parameter.name}<#if parameter_has_next>, </#if></#list><#t>
</#macro>

<#macro method method>
    <@modifiers method.modifiers/> <@returnType method/> ${method.name}(<@parameters method.parameters/>) {
    <@methodImplementatoin method/>
    }

</#macro>

<#macro property property>
    <#if property.upper == 1 >
    <@modifiers property.modifiers/> ${property.type.name} ${property.name};
    <#elseif property.upper == -1 >
    <@modifiers property.modifiers/> Set<${property.type.name}> ${property.name} = new HashSet<>();
    <#else>
        <#list 1..property.upper as i>
    <@modifiers property.modifiers/> ${property.type.name} ${property.name}${i};
        </#list>
    </#if>
    <#t>
</#macro>

<#macro setter property>
    public void set${property.name?cap_first}(${property.type.name} ${property.name}) {
        this.${property.name} = ${property.name};
    }
</#macro>

<#macro getter property>
    public ${property.type.name} get${property.name?cap_first}() {
        return this.${property.name};
    }
</#macro>
package ${class.typePackage};

import java.util.*;
<#list imports as import>
import ${import};
</#list>

<#list class.modifiers as modifier>${modifier} </#list>class ${class.name} <#if class.superClass??>extends ${class.superClass.name}</#if> {

<#list properties as p>
    <@property p/>
</#list>

<#list methods as m>
    <@method m/>
</#list>
    // Getters and setters
<#list properties as p>
    <#if p.getter??>
        <@getter p/>

    </#if>
    <#if p.setter??>
        <@setter p/>

    </#if>
</#list>
}
