package com.org.coop.retail.entities;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;
import com.mysema.query.types.path.PathInits;


/**
 * QMaterialTranDtl is a Querydsl query type for MaterialTranDtl
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMaterialTranDtl extends EntityPathBase<MaterialTranDtl> {

    private static final long serialVersionUID = -1022079554L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMaterialTranDtl materialTranDtl = new QMaterialTranDtl("materialTranDtl");

    public final QBranchMaster branchMaster;

    public final DateTimePath<java.sql.Timestamp> createDate = createDateTime("createDate", java.sql.Timestamp.class);

    public final StringPath createUser = createString("createUser");

    public final StringPath deleteInd = createString("deleteInd");

    public final StringPath deleteReason = createString("deleteReason");

    public final DatePath<java.util.Date> endDate = createDate("endDate", java.util.Date.class);

    public final QMaterialTranHrd materialTranHrd;

    public final StringPath passingAuthInd = createString("passingAuthInd");

    public final StringPath passingAuthRemark = createString("passingAuthRemark");

    public final NumberPath<java.math.BigDecimal> qty = createNumber("qty", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> rate = createNumber("rate", java.math.BigDecimal.class);

    public final QStockEntry stockEntry;

    public final NumberPath<java.math.BigDecimal> total = createNumber("total", java.math.BigDecimal.class);

    public final NumberPath<Integer> tranDtlId = createNumber("tranDtlId", Integer.class);

    public final DateTimePath<java.sql.Timestamp> updateDate = createDateTime("updateDate", java.sql.Timestamp.class);

    public final StringPath updateUser = createString("updateUser");

    public QMaterialTranDtl(String variable) {
        this(MaterialTranDtl.class, forVariable(variable), INITS);
    }

    public QMaterialTranDtl(Path<? extends MaterialTranDtl> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QMaterialTranDtl(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QMaterialTranDtl(PathMetadata<?> metadata, PathInits inits) {
        this(MaterialTranDtl.class, metadata, inits);
    }

    public QMaterialTranDtl(Class<? extends MaterialTranDtl> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.branchMaster = inits.isInitialized("branchMaster") ? new QBranchMaster(forProperty("branchMaster")) : null;
        this.materialTranHrd = inits.isInitialized("materialTranHrd") ? new QMaterialTranHrd(forProperty("materialTranHrd"), inits.get("materialTranHrd")) : null;
        this.stockEntry = inits.isInitialized("stockEntry") ? new QStockEntry(forProperty("stockEntry"), inits.get("stockEntry")) : null;
    }

}

