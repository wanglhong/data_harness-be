package supie.webadmin.app.service;

import com.alibaba.fastjson.JSONObject;
import supie.webadmin.app.model.*;
import supie.common.core.base.service.IBaseService;

import java.util.*;

/**
 * 数据规划-数据标准-数据字段标准数据操作服务接口。
 *
 * @author rm -rf .bug
 * @date 2020-11-12
 */
public interface StandardFieldService extends IBaseService<StandardField, Long> {

    /**
     * 保存新增对象。
     *
     * @param standardField 新增对象。
     * @return 返回新增对象。
     */
    StandardField saveNew(StandardField standardField);

    /**
     * 利用数据库的insertList语法，批量插入对象列表。
     *
     * @param standardFieldList 新增对象列表。
     */
    void saveNewBatch(List<StandardField> standardFieldList);

    /**
     * 保存新增主表对象及关联对象。
     *
     * @param standardField 新增主表对象。
     * @param relationData 全部关联从表数据。
     * @return 返回新增主表对象。
     */
    StandardField saveNewWithRelation(StandardField standardField, JSONObject relationData);

    /**
     * 更新数据对象。
     *
     * @param standardField         更新的对象。
     * @param originalStandardField 原有数据对象。
     * @return 成功返回true，否则false。
     */
    boolean update(StandardField standardField, StandardField originalStandardField);

    /**
     * 删除指定数据。
     *
     * @param id 主键Id。
     * @return 成功返回true，否则false。
     */
    boolean remove(Long id);

    /**
     * 当前服务的支持表为从表，根据主表的关联Id，删除一对多的从表数据。
     *
     * @param staidardId 从表关联字段。
     * @return 删除数量。
     */
    int removeByStaidardId(Long staidardId);

    /**
     * 获取单表查询结果。由于没有关联数据查询，因此在仅仅获取单表数据的场景下，效率更高。
     * 如果需要同时获取关联数据，请移步(getStandardFieldListWithRelation)方法。
     *
     * @param filter  过滤对象。
     * @param orderBy 排序参数。
     * @return 查询结果集。
     */
    List<StandardField> getStandardFieldList(StandardField filter, String orderBy);

    /**
     * 获取主表的查询结果，以及主表关联的字典数据和一对一从表数据，以及一对一从表的字典数据。
     * 该查询会涉及到一对一从表的关联过滤，或一对多从表的嵌套关联过滤，因此性能不如单表过滤。
     * 如果仅仅需要获取主表数据，请移步(getStandardFieldList)，以便获取更好的查询性能。
     *
     * @param filter 主表过滤对象。
     * @param orderBy 排序参数。
     * @return 查询结果集。
     */
    List<StandardField> getStandardFieldListWithRelation(StandardField filter, String orderBy);

    /**
     * 获取分组过滤后的数据查询结果，以及关联的字典数据和一对一从表数据，以及一对一从表的字典数据。
     *
     * @param filter      过滤对象。
     * @param groupSelect 分组显示列表参数。位于SQL语句SELECT的后面。
     * @param groupBy     分组参数。位于SQL语句的GROUP BY后面。
     * @param orderBy     排序字符串，ORDER BY从句的参数。
     * @return 分组过滤结果集。
     */
    List<StandardField> getGroupedStandardFieldListWithRelation(
            StandardField filter, String groupSelect, String groupBy, String orderBy);

    /**
     * 批量添加多对多关联关系。
     *
     * @param standardFieldQualityList 多对多关联表对象集合。
     * @param staidardFieldId 主表Id。
     */
    void addStandardFieldQualityList(List<StandardFieldQuality> standardFieldQualityList, Long staidardFieldId);

    /**
     * 更新中间表数据。
     *
     * @param standardFieldQuality 中间表对象。
     * @return 更新成功与否。
     */
    boolean updateStandardFieldQuality(StandardFieldQuality standardFieldQuality);

    /**
     * 获取中间表数据。
     *
     * @param staidardFieldId 主表Id。
     * @param staidardQualityId 从表Id。
     * @return 中间表对象。
     */
    StandardFieldQuality getStandardFieldQuality(Long staidardFieldId, Long staidardQualityId);

    /**
     * 移除单条多对多关系。
     *
     * @param staidardFieldId 主表Id。
     * @param staidardQualityId 从表Id。
     * @return 成功返回true，否则false。
     */
    boolean removeStandardFieldQuality(Long staidardFieldId, Long staidardQualityId);
}
