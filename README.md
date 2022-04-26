# quarkus-reactive-postgis-reproducer

Reproducer with postgis and reactive panache.


1. Start Quarkus in dev mode  
`mvn quarkus:dev`


2. Call endpoint

`curl -X GET http://localhost:8080/location`

3. Expected Data  

  
`[{"name":"test","geom":{"type":"Point","coordinates":[550700.0,5801000.0]}}]`


4. Actual Data
```
2022-04-26 10:47:46,608 ERROR [org.jbo.res.rea.com.cor.AbstractResteasyReactiveContext] (vert.x-eventloop-thread-2) Request failed: java.lang.ClassCastException: class java.lang.String cannot be cast to class io.vertx.core.buffer.Buffer (java.lang.String is in module java.base of loader 'bootstrap'; io.vertx.co
re.buffer.Buffer is in unnamed module of loader io.quarkus.bootstrap.classloading.QuarkusClassLoader @378542de)
        at io.vertx.sqlclient.Tuple.getBuffer(Tuple.java:592)
        at io.vertx.sqlclient.Row.getBuffer(Row.java:351)
        at org.hibernate.reactive.adaptor.impl.ResultSetAdaptor.getBytes(ResultSetAdaptor.java:257)
        at org.hibernate.type.descriptor.sql.VarbinaryTypeDescriptor$2.doExtract(VarbinaryTypeDescriptor.java:60)
        at org.hibernate.type.descriptor.sql.BasicExtractor.extract(BasicExtractor.java:47)
        at org.hibernate.type.AbstractStandardBasicType.nullSafeGet(AbstractStandardBasicType.java:257)
        at org.hibernate.type.AbstractStandardBasicType.nullSafeGet(AbstractStandardBasicType.java:253)
        at org.hibernate.type.AbstractStandardBasicType.nullSafeGet(AbstractStandardBasicType.java:243)
        at org.hibernate.type.AbstractStandardBasicType.hydrate(AbstractStandardBasicType.java:329)
        at org.hibernate.persister.entity.AbstractEntityPersister.hydrate(AbstractEntityPersister.java:3214)
        at org.hibernate.loader.Loader.loadFromResultSet(Loader.java:1887)
        at org.hibernate.loader.Loader.hydrateEntityState(Loader.java:1811)
        at org.hibernate.loader.Loader.instanceNotYetLoaded(Loader.java:1784)
        at org.hibernate.loader.Loader.getRow(Loader.java:1624)
        at org.hibernate.loader.Loader.getRowFromResultSet(Loader.java:748)
        at org.hibernate.loader.Loader.getRowsFromResultSet(Loader.java:1047)
        at org.hibernate.reactive.loader.hql.impl.ReactiveQueryLoader.getRowsFromResultSet(ReactiveQueryLoader.java:223)
        at org.hibernate.reactive.loader.ReactiveLoaderBasedResultSetProcessor.reactiveExtractResults(ReactiveLoaderBasedResultSetProcessor.java:73)
        at org.hibernate.reactive.loader.hql.impl.ReactiveQueryLoader$1.reactiveExtractResults(ReactiveQueryLoader.java:72)
        at org.hibernate.reactive.loader.ReactiveLoader.reactiveProcessResultSet(ReactiveLoader.java:145)
        at org.hibernate.reactive.loader.ReactiveLoader.lambda$doReactiveQueryAndInitializeNonLazyCollections$0(ReactiveLoader.java:77)
        at java.base/java.util.concurrent.CompletableFuture$UniCompose.tryFire(CompletableFuture.java:1146)
        at java.base/java.util.concurrent.CompletableFuture.postComplete(CompletableFuture.java:506)
        at java.base/java.util.concurrent.CompletableFuture.complete(CompletableFuture.java:2144)
        at io.vertx.core.Future.lambda$toCompletionStage$2(Future.java:360)
        at io.vertx.core.impl.future.FutureImpl$3.onSuccess(FutureImpl.java:141)
        at io.vertx.core.impl.future.FutureBase.emitSuccess(FutureBase.java:60)
        at io.vertx.core.impl.future.FutureImpl.tryComplete(FutureImpl.java:211)
        at io.vertx.core.impl.future.PromiseImpl.tryComplete(PromiseImpl.java:23)
        at io.vertx.sqlclient.impl.QueryResultBuilder.tryComplete(QueryResultBuilder.java:102)
        at io.vertx.sqlclient.impl.QueryResultBuilder.tryComplete(QueryResultBuilder.java:35)
        at io.vertx.core.Promise.complete(Promise.java:66)
        at io.vertx.core.Promise.handle(Promise.java:51)
        at io.vertx.core.Promise.handle(Promise.java:29)
        at io.vertx.core.impl.future.FutureImpl$3.onSuccess(FutureImpl.java:141)
        at io.vertx.core.impl.future.FutureBase.lambda$emitSuccess$0(FutureBase.java:54)
        at io.vertx.core.impl.EventLoopContext.execute(EventLoopContext.java:81)
        at io.vertx.core.impl.DuplicatedContext.execute(DuplicatedContext.java:173)
        at io.vertx.core.impl.future.FutureBase.emitSuccess(FutureBase.java:51)
        at io.vertx.core.impl.future.FutureImpl.tryComplete(FutureImpl.java:211)
        at io.vertx.core.impl.future.PromiseImpl.tryComplete(PromiseImpl.java:23)
        at io.vertx.core.impl.future.PromiseImpl.onSuccess(PromiseImpl.java:49)
        at io.vertx.core.impl.future.PromiseImpl.handle(PromiseImpl.java:41)
        at io.vertx.core.impl.future.PromiseImpl.handle(PromiseImpl.java:23)
        at io.vertx.sqlclient.impl.command.CommandResponse.fire(CommandResponse.java:46)
        at io.vertx.sqlclient.impl.SocketConnectionBase.handleMessage(SocketConnectionBase.java:287)
        at io.vertx.pgclient.impl.PgSocketConnection.handleMessage(PgSocketConnection.java:96)
        at io.vertx.sqlclient.impl.SocketConnectionBase.lambda$init$0(SocketConnectionBase.java:99)
        at io.vertx.core.impl.EventLoopContext.emit(EventLoopContext.java:50)
        at io.vertx.core.impl.ContextImpl.emit(ContextImpl.java:274)
        at io.vertx.core.impl.EventLoopContext.emit(EventLoopContext.java:22)
        at io.vertx.core.net.impl.NetSocketImpl.handleMessage(NetSocketImpl.java:394)
        at io.vertx.core.net.impl.ConnectionBase.read(ConnectionBase.java:156)
        at io.vertx.core.net.impl.VertxHandler.channelRead(VertxHandler.java:153)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:379)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:365)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:357)
        at io.netty.channel.CombinedChannelDuplexHandler$DelegatingChannelHandlerContext.fireChannelRead(CombinedChannelDuplexHandler.java:436)
        at io.vertx.pgclient.impl.codec.PgEncoder.lambda$write$0(PgEncoder.java:87)
        at io.vertx.pgclient.impl.codec.PgCommandCodec.handleReadyForQuery(PgCommandCodec.java:139)
        at io.vertx.pgclient.impl.codec.PgDecoder.decodeReadyForQuery(PgDecoder.java:237)
        at io.vertx.pgclient.impl.codec.PgDecoder.channelRead(PgDecoder.java:96)
        at io.netty.channel.CombinedChannelDuplexHandler.channelRead(CombinedChannelDuplexHandler.java:251)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:379)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:365)
        at io.netty.channel.AbstractChannelHandlerContext.fireChannelRead(AbstractChannelHandlerContext.java:357)
        at io.netty.channel.DefaultChannelPipeline$HeadContext.channelRead(DefaultChannelPipeline.java:1410)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:379)
        at io.netty.channel.AbstractChannelHandlerContext.invokeChannelRead(AbstractChannelHandlerContext.java:365)
        at io.netty.channel.DefaultChannelPipeline.fireChannelRead(DefaultChannelPipeline.java:919)
        at io.netty.channel.nio.AbstractNioByteChannel$NioByteUnsafe.read(AbstractNioByteChannel.java:166)
        at io.netty.channel.nio.NioEventLoop.processSelectedKey(NioEventLoop.java:722)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeysOptimized(NioEventLoop.java:658)
        at io.netty.channel.nio.NioEventLoop.processSelectedKeys(NioEventLoop.java:584)
        at io.netty.channel.nio.NioEventLoop.run(NioEventLoop.java:496)
        at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:986)
        at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
        at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.base/java.lang.Thread.run(Thread.java:835)


```
